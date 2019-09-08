package com.imooc.Controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/getProductCategory")
    public ProductCategory getProductCategory(Integer id) {
        return categoryService.findOne(id);
    }
}
