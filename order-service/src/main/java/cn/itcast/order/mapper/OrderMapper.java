package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author itcast
 * 订单Mapper
 */
@Mapper
public interface OrderMapper {
    /**
     * 根据id获取订单数据
     *
     * @param id 订单id
     * @return 订单数据
     */
    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
