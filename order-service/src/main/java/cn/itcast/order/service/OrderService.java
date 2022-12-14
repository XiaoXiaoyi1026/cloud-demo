package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.itcast.feignapi.clients.UserClient;
import cn.itcast.feignapi.pojo.User;

/**
 * @author itcast
 * 订单Service
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

/*    @Autowired
    private RestTemplate restTemplate;*/

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 根据order中的userId远程调用user服务进行查询
        // 2.1 拼凑url
//        String url = "http://userservice/user/" + order.getUserId();
        // 2.2 使用RestTemplate发送Get请求
//        User user = restTemplate.getForObject(url, User.class);
        // 3. 封装数据
//        order.setUser(user);

        // 2. 使用Feign远程调用，代替RestTemplate
        User user = userClient.findById(order.getUserId());
        // 3. 封装数据
        order.setUser(user);

        // 4.返回
        return order;
    }

    @SentinelResource("goods")
    public void queryGoods() {
        System.err.println("查询商品");
    }
}
