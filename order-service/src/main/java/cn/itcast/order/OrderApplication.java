package cn.itcast.order;

// import com.netflix.loadbalancer.IRule;
// import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import cn.itcast.feignapi.clients.UserClient;
import cn.itcast.feignapi.config.DefaultFeignConfiguration;

/**
 * @author itcast
 * 订单应用
 */
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication(exclude = IntegrationAutoConfiguration.class)
@EnableFeignClients(clients = UserClient.class, defaultConfiguration = DefaultFeignConfiguration.class)
@EnableCaching
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public IRule randomRule() {
        return new RandomRule();
    }*/

}