package cn.itcast.order.clients;

import cn.itcast.order.config.DefaultFeignConfiguration;
import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaoxiaoyi
 * Feign发起http请求
 */
@FeignClient(value = "userservice", configuration = DefaultFeignConfiguration.class)
public interface UserClient {

    /**
     * 根据id查询user, 使用Feign代替RestTemplate发送请求
     *
     * @param id userId
     * @return user
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
