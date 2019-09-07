package com.imooc.Controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CatagoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController

public class BuyerProductController {


    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/saveProductInfo",method = RequestMethod.POST)
    public ProductInfo saveProductInfo(ProductInfo productInfo) {
        return productService.save(productInfo);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public Page<ProductInfo> findAll(int page, int size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return productService.findAll(pageRequest);
    }

    @GetMapping("/list")
    public ResultVO list() {
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        List<ProductInfoVO> lists = new ArrayList<>();
        lists.add(new ProductInfoVO("666","要成功",new BigDecimal(666),"不错哦","xxxx.com"));
        lists.add(new ProductInfoVO("777","要成功",new BigDecimal(777),"不错哦","yyyy.com"));
        lists.add(new ProductInfoVO("888","要成功",new BigDecimal(888),"不错哦","zzzz.com"));

//        List<ProductVO> listss = new ArrayList<>();
//        listss.add(new ProductVO("一", 1, lists));
//        listss.add(new ProductVO("二", 2, lists));
//        resultVO.setData(listss);


        resultVO.setData(new ProductVO("一",1,lists));
        return resultVO;


    }
}
