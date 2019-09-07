package com.imooc.Controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CategoryController {
    @Autowired
    private CatagoryService catagoryService;
    @RequestMapping("/getProductCategory")
    public ProductCategory getProductCategory(Integer id) {
        return catagoryService.findOne(id);
    }
}
