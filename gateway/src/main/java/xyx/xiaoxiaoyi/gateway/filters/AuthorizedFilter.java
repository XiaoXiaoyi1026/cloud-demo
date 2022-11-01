package xyx.xiaoxiaoyi.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xiaoxiaoyi
 */
@Component
public class AuthorizedFilter implements GlobalFilter, Ordered {
    /**
     * 过滤方法, 用于编写具体的过滤逻辑
     *
     * @param exchange 请求上下文对象
     * @param chain    过滤器链
     * @return 响应式编程, 非阻塞, 返回处理结果
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        // 2. 获取请求参数中的authorized参数
        String authorized = params.getFirst("authorized");
        // 3. 判断authorized参数是否为admin
        if ("admin".equals(authorized)) {
            // 4. 是, 则放行
            return chain.filter(exchange);
        }
        // 5. 不是, 则拦截
        // 5.1 设置response的状态码为401, 代表未授权
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        // 5.2 设置response的状态为完成并返回
        return response.setComplete();
    }

    /**
     * 设置过滤器的优先级, 返回值越小优先级越高
     * 亦可使用@Order注解进行配置
     *
     * @return 优先级
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
