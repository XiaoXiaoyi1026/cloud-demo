package cn.itcast.feignapi.clients.fallback;

import cn.itcast.feignapi.clients.UserClient;
import cn.itcast.feignapi.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author xiaoxiaoyi
 * 降级处理逻辑
 */
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        return id -> {
            // 记录失败日志
            log.error("查询用户" + id + "失败");
            // 创建失败返回的用户
            User user = new User();
            user.setId(id);
            user.setUsername("查询失败");
            user.setAddress("");
            // 返回失败的用户给前端
            return user;
        };
    }
}
