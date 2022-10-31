package cn.itcast.order.pojo;

import lombok.Data;
import xyx.xiaoxiaoyi.feignapi.pojo.User;

/**
 * @author xiaoxiaoyi
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