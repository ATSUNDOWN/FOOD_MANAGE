package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("cart")
@Data
public class Cart {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String uid;
    private String fid;
    private Integer fcount;
}
