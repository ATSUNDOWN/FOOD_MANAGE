package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysj.entity.Favorites;
import com.ysj.entity.Food;
import com.ysj.mapper.FavoritesMapper;
import com.ysj.service.FavoritesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements FavoritesService{
    @Resource
    private FavoritesMapper favoritesMapper;
    @Override
    public List<Food> showFavorites(String username) {
        return favoritesMapper.showFavorites(username);
    }

    @Override
    public void addCollection(String fid, String username) {
        favoritesMapper.addCollection(fid,username);
    }

    @Override
    public void cancelFavorites(String fid) {
        favoritesMapper.cancelFavorites(fid);
    }
}
