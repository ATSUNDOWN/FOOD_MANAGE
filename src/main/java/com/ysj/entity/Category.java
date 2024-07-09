package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("category")
@Data
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String pattern;
}
