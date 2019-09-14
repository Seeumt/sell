package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象 viewobject
 */
@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 3068837394742385883L;

    private Integer code;
    private String msg;
    private T data;


}
