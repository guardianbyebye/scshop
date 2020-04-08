package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.User;

public interface userService {
    /**
     * 注册
     */
    boolean addUser(User user);

    /**
     * 验证用户名是否存在
     */
    boolean checkUserName(String userName);
    /**
     * 验证邮箱是否存在
     */
    boolean checkEmail(String email);
    /**
     * 登录验证用户名和密码
     */
    boolean checkUserNameAndPwd(String userName,String password);
    /**
     * 根据用户名获取用户信息
     */
    User selectUserByUserName(String userName);
    /**
     * 修改用户信息
     */
    boolean updateUserInfo(User user);
    /**
     * 修改密码
     */
    boolean updateUserPwd(String userName,String password);

}
