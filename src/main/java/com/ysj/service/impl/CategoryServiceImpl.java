package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysj.entity.Category;
import com.ysj.mapper.CategoryMapper;
import com.ysj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> selectPatternInfo() {
        return categoryMapper.selectPatternInfo();
    }
}
