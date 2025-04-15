package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {


    @Select("select count(*) from setmeal_dish where dish_id = #{id}")
    int countInSetmeal(Long id);
}
