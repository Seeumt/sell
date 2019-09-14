package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {
    @Resource
    private ProductCategoryMapper productCategoryMapper;
    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "测试，没注入哦");
        map.put("category_type", "101");
        int result = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("没注入也行");
        productCategory.setCategoryType(102);
        int result = productCategoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
        System.out.println(result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory result = productCategoryMapper.findByCategoryType(1);
        System.out.println(result);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = productCategoryMapper.findByCategoryName("耳机");
        System.out.println(result);
    }

    @Test
    public void updateByCategoryType() {
        int result = productCategoryMapper.updateByCategoryType("无线鼠标", 102);
        System.out.println(result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("无线耳机");
        productCategory.setCategoryType(102);
        int result = productCategoryMapper.updateByObject(productCategory);
        System.out.println(result);
    }

    @Test
    public void deleteByCategoryType() {
        int result = productCategoryMapper.deleteByCategoryType(102);
        System.out.println(result);
    }
}