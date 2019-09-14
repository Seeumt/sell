package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductVO implements Serializable {
    private static final long serialVersionUID = 3068837394742385884L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


    public ProductVO() {
    }

    public ProductVO(String categoryName, Integer categoryType, List<ProductInfoVO> productInfoVOList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.productInfoVOList = productInfoVOList;
    }
}
