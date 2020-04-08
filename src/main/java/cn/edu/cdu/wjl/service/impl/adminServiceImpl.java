package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.adminDao;
import cn.edu.cdu.wjl.Entity.Admin;
import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements adminService {
    @Autowired
    adminDao adminDao;


    @Override
    public boolean checkAdminPwd(String amdin_name, String admin_pwd) {
        if(admin_pwd.equals(adminDao.selectAdminPwdByName(amdin_name)))
            return true;
        else
            return false;
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return adminDao.selectAllAdmin();
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public Admin selectAdminByName(String admin_name) {
        return adminDao.selectAdminByName(admin_name);
    }


    @Override
    public List<User> selectAllUsers() {
        return adminDao.selectAllUsers();
    }

    @Override
    public boolean deleteUserById(int user_id) {
        return adminDao.deleteUserById(user_id);
    }

    @Override
    public boolean deleteAdminById(int admin_id) {
        return adminDao.deleteAdminById(admin_id);
    }

    @Override
    public List<Good> selectAllGoods() {
        return adminDao.selectAllGoods();
    }
}
