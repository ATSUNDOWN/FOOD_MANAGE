package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("favorites")
@Data
public class Favorites {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String fid;
}
