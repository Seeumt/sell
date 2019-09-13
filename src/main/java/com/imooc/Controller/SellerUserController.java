package com.imooc.Controller;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisConstant;
import com.imooc.dataobject.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.service.SellerService;
import com.imooc.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
public class SellerUserController {
    @Resource
    private SellerService sellerService;

    @Autowired
    //写一个String类型的值
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String,Object> map) {

        //1.查询openid是否匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2.设置token到redis
            //（1）生成一个UUID作为token
        String token = UUID.randomUUID().toString();
            //(2)设置过期时间
        /**
         * 这个expire是redis中的过期时间
         */
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token), openid,expire, TimeUnit.SECONDS);
        //3.设置token至cookie
        //        简化操作，写出工具类
        //        Cookie cookie = new Cookie("token", token);
        //        cookie.setPath("/path");
        //        cookie.setMaxAge(7200);
        //        response.addCookie(cookie);
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);

        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String, Object> map) {
        //1.从cookie中查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        //2.清除redis
        if (cookie != null) {
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
