package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import com.imooc.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId("8");
        sellerInfo.setUsername("James");
        sellerInfo.setPassword("123456");
        sellerInfo.setOpenid("888wx");
        repository.save(sellerInfo);
    }
    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = repository.findByOpenid("666wx");
        System.out.println(JsonUtil.toJson(sellerInfo));
    }
}