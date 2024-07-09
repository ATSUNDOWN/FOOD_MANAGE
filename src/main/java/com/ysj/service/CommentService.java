package com.ysj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysj.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService extends IService<Comment> {
    void insertComment(@Param("commentContent") String commentContent, @Param("uid") String uid, @Param("nickName") String nickName);
    List<Comment> selectAllComment();

}
