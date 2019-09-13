package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.service.SellerService;
import com.imooc.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {
    @Autowired
    private SellerService sellerService;

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid("666wx");
        System.out.println(JsonUtil.toJson(sellerInfo));
    }

}