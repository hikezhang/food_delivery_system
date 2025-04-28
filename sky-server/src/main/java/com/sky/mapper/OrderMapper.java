package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    // 插入订单数据
    void insert(Orders orders);

    // 分页查询历史订单
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);


    // 按订单id查询订单数据
    @Select("select * from orders where id = #{orderId}")
    Orders getById(Long orderId);

    // 更新订单状态
    void update(Orders order);

    // 按状态统计订单数量
    @Select("select count(*) from orders where status = #{status}")
    Integer countStatus(Integer status);

    // 查找超时订单
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status, LocalDateTime orderTime);

    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    // 查询当日营业额
    Double sumByMap(Map map);

    // 查询当日订单数量
    Integer countByMap(Map map);

    // 查询商品销量
    List<GoodsSalesDTO> getSalesTop(LocalDateTime begin, LocalDateTime end);
}
