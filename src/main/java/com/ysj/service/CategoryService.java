package com.ysj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysj.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService extends IService<Category> {
    List<Category> selectPatternInfo();
}
