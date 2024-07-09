package com.ysj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.common.Result;
import com.ysj.entity.Comment;
import com.ysj.entity.User;
import com.ysj.mapper.CommentMapper;
import com.ysj.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@Controller
@RequestMapping("/comment")
public class CommentController{
    @Resource
    private CommentService commentService;
    @Resource
    private CommentMapper commentMapper;

    @GetMapping("/insertComment")
    public Result<?> insertComment(@RequestParam(defaultValue = "")String commentContent,@RequestParam(defaultValue = "")String uid,@RequestParam(defaultValue = "")String nickName){
        commentService.insertComment(commentContent, uid, nickName);
        return Result.success();
    }
    @GetMapping("/selectAllComment")
    public Result<?> selectAllComment(){
        List<Comment> list = commentService.selectAllComment();
        return Result.success(list);
    }
    @GetMapping
    public Result<?> findPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Comment> wrapper = Wrappers.<Comment>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Comment::getUid,search);
        }
        Page<Comment> userPage = commentMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(userPage);
    }
    //    删除
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable long id){
        commentMapper.deleteById(id);
        return Result.success();
    }
}
