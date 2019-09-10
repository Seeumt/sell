package com.imooc.Controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wechat")
@Slf4j

public class WechatController {
    public void anthorize(@RequestParam("returnUrl") String returnUrl) {
        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
        //1.配置
        //
    }
}
