package com.imooc.enums;

import com.lly835.bestpay.rest.type.Get;
import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1,"下架"),
    CANCEL(2,"已取消")

    ;
    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ProductStatusEnum() {
    }


}
