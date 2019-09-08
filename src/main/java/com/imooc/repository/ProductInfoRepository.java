package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
//在哪里实现呢

//    ProductInfo save(ProductInfo productInfo);

//    ProductInfo findOne(Integer id);
}
