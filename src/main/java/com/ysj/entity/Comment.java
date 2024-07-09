package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("comment")
@Data
public class Comment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String commentContent;
    private String uid;
    private String nickName;
}
