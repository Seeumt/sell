package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Resource
    private ProductService productService;
    @Test
    public void onSale() {
        ProductInfo productInfo = productService.onSale("1");
        System.out.println(productInfo);
    }

    @Test
    public void offSale() {
        ProductInfo productInfo = productService.offSale("2");
        System.out.println(productInfo);
    }
}