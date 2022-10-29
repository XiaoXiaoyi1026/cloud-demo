package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

   @Autowired
   private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {

        // 1. 查询订单
        Order order = orderService.queryOrderById(orderId);

        // 2. 根据order中的userId远程调用user服务进行查询
        // 2.1 拼凑url
        String url = "http://userservice/user/" + order.getUserId();
        // 2.2 使用RestTemplate发送Get请求
        User user = restTemplate.getForObject(url, User.class);
        // 3. 封装数据
        order.setUser(user);
        // 4. 返回order
        return order;
    }
}
