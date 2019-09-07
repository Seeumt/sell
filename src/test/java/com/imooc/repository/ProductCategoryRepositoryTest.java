package com.imooc.repository;

import com.imooc.SellApplication;
import com.imooc.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest("ProductCategoryRepositoryTest.class")

public class ProductCategoryRepositoryTest {
    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
        ProductCategory one = productCategoryRepository.findOne(1);
        System.out.println(one);

    }



}