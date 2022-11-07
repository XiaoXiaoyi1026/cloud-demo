package cn.itcast.order.pojo;

import lombok.Data;
import cn.itcast.feignapi.pojo.User;

/**
 * @author itcast
 * 订单数据
 */
@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}