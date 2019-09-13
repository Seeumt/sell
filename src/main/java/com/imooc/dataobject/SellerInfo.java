package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@DynamicUpdate
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
    private Timestamp createTime;
    private Timestamp updateTime;}



