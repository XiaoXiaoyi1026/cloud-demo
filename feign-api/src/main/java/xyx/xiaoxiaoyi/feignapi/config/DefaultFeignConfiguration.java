package xyx.xiaoxiaoyi.feignapi.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author xiaoxiaoyi
 * 默认Feign配置类
 */
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level logLevel() {
        // 指定日志等级，是枚举类
        return Logger.Level.BASIC;
    }

}
