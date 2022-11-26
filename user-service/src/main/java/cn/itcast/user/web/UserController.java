package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author itcast
 * 用户请求控制类
 * {@code @RefreshScope} 注解可用于和@Value配合实现配置热加载
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*@Value("${pattern.dateformat}")
    private String dateFormat;*/

    @Autowired
    private PatternProperties patternProperties;

    @GetMapping("/prop")
    public PatternProperties patternProperties() {
        return patternProperties;
    }

    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, @RequestHeader(value = "Truth", required = false) String truth) throws InterruptedException {
        System.out.println(truth);
        if (id == 1) {
            // 触发熔断
            Thread.sleep(60);
        } else if (id == 2) {
            // 抛异常, 触发熔断
            throw new RuntimeException("故意抛异常, 触发熔断");
        }
        return userService.queryById(id);
    }
}
