package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaoxiaoyi
 * 请求头过滤器
 */
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 尝试获取请求头
        String origin = request.getHeader("origin");
        // 非空判断
        if (StringUtils.isNullOrEmpty(origin)) {
            // 如果请求头的origin为null或者空, 则说明为黑名单
            origin = "black";
        }
        return origin;
    }
}
