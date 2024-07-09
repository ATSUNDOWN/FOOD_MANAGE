package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("ordering")
@Data
public class Ordering {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String oid;
    private Integer status;
    private String username;
    private String address;
}
