package com.ysj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysj.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    //存入评论信息
    void insertComment(@Param("commentContent") String commentContent,@Param("uid") String uid,@Param("nickName") String nickName);
    //查询所有评论
    List<Comment> selectAllComment();
}
