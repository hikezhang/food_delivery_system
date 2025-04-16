package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);


    @AutoFill(value = OperationType.INSERT)
    void insert(Setmeal setmeal);

    // 套餐分页查询
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    // 套餐批量删除
    void delete(List<Long> ids);

    // 修改功能第一步：按id查询套餐数据
    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);

    // 更新套餐表信息
    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setmeal);
}
