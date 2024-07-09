package com.ysj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysj.entity.Favorites;
import com.ysj.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface FavoritesMapper extends BaseMapper<Favorites> {
//    显示收藏夹信息
    List<Food> showFavorites(@Param("username") String username);
//    将食品添入收藏夹
    void addCollection(@Param("fid") String fid,@Param("username") String username);
//    取消收藏
    void cancelFavorites(@Param("fid") String fid);
}

