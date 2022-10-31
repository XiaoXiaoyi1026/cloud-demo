package xyx.xiaoxiaoyi.feignapi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyx.xiaoxiaoyi.feignapi.config.DefaultFeignConfiguration;
import xyx.xiaoxiaoyi.feignapi.pojo.User;

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
