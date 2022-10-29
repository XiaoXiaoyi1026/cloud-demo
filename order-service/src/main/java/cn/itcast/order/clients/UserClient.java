package cn.itcast.order.clients;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaoxiaoyi
 */

@FeignClient("userservice")
public interface UserClient {

    /**
     * 根据id查询user
     *
     * @param id userId
     * @return user
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
