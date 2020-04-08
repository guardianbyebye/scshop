package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface userDao {
    /**
     * 注册新用户
     */
    boolean addUser(User user);

    /**
     * 查询用户
     */
    User selectUserByUserName(String user_name);
    /**
     * 查询邮箱
     */
    User selectEmail(String email);
    /**
     * 验证账号密码
     */
    String selectPasswordByUserName(String userName);
    /**
     * 更新用户信息
     * @param user
     */
    boolean updateUserInfo(User user);

    /**
     * 修改密码
     * @param userName
     * @param password
     * @return
     */
    boolean updateUserPwd(String userName,String password);
}
