package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysj.entity.Comment;
import com.ysj.mapper.CommentMapper;
import com.ysj.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper,Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public void insertComment(String commentContent, String uid, String nickName) {
        commentMapper.insertComment(commentContent,uid,nickName);
    }

    @Override
    public List<Comment> selectAllComment() {
        return commentMapper.selectAllComment();
    }
}
