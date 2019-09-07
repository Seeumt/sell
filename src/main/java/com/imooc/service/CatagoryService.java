package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import javax.persistence.Id;
import java.util.List;

public interface CatagoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> category);

    ProductCategory save(ProductCategory productCategory);
}
