package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Admin;
import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface adminDao {
    /**
     * 登陆验证
     */
    String selectAdminPwdByName(String admin_name);
    /**
     * 查询所有管理员
     */
    List<Admin> selectAllAdmin();
    /**
     * 新增管理员
     */
    boolean addAdmin(Admin admin);
    /**
     * 更新管理员
     */
    boolean updateAdmin(Admin admin);
    /**
     * 查询管理员
     */
    Admin selectAdminByName(String admin_name);
    /**
     * 查询所有用户
     */
    List<User> selectAllUsers();
    /**
     *删除用户
     */
    boolean deleteUserById(int user_id);
    /**
     * 删除管理员
     */
    boolean deleteAdminById(int admin_id);
    /**
     * 查询所有商品
     */
    List<Good> selectAllGoods();
}
