package cn.itcast.user.pojo;

import lombok.Data;

/**
 * @author xiaoxiaoyi
 * 用户
 */
@Data
public class User {
    private Long id;
    private String username;
    private String address;
}