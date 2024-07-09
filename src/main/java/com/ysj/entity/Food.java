package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("food")
@Data
public class Food {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String foodPic;
    private String foodName;
    private BigDecimal price;
    private String fid;
    private String pattern;
    private String content;
}
