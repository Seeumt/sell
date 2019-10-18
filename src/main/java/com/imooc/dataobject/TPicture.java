package com.imooc.dataobject;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name="t_picture")
public class TPicture {

    @Id
    @GeneratedValue
    private Integer id;

    private String picName;
    private String url;



}
