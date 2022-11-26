package cn.itcast.feignapi.config;

import cn.itcast.feignapi.clients.fallback.UserClientFallbackFactory;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author itcast
 * 默认Feign配置类
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel() {
        // 指定日志等级，是枚举类, 有BASIC, NONE, HEADERS, FULL;
        return Logger.Level.BASIC;
    }

    /**
     * 将fallback Factory注册成为一个bean
     */
    @Bean
    public UserClientFallbackFactory userClientFallbackFactory() {
        return new UserClientFallbackFactory();
    }
}
