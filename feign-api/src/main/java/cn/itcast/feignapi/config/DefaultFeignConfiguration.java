package cn.itcast.feignapi.config;

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
}
