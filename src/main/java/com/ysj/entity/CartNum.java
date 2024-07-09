package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartNum {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer fcount;
    private String foodPic;
    private String foodName;
    private BigDecimal price;
    private String fid;
}
