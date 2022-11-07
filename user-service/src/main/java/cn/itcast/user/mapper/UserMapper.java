package cn.itcast.user.mapper;

import cn.itcast.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author itcast
 * 用户Mapper
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}