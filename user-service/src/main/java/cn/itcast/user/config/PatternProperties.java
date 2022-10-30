package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiaoxiaoyi
 * 读取nacos上的配置文件信息
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    /**
     * 读取${pattern.dateformat}
     */
    private String dateformat;
    private String envSharedProperty;
    private String name;
}
