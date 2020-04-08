package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.userDao;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.Utils.MD5Utils;
import cn.edu.cdu.wjl.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class userServiceImpl implements userService {
    @Autowired
    userDao userDao;


    @Override
    public boolean addUser(User user) {
        String password=user.getUser_pwd();
        String newPwd=MD5Utils.setDBPwd(password);
        user.setUser_pwd(newPwd);
        return userDao.addUser(user);
    }

    @Override
    public boolean checkUserName(String userName) {
        if(userDao.selectUserByUserName(userName)==null)
            return false;
        else
            return true;
    }

    @Override
    public boolean checkEmail(String email) {
        if(userDao.selectEmail(email)==null)
            return false;
        else
            return true;
    }

    @Override
    public boolean checkUserNameAndPwd(String userName, String password) {
        String newPwd=MD5Utils.setDBPwd(password);
        System.out.println(newPwd);
        if(newPwd.equals(userDao.selectPasswordByUserName(userName)))
            return true;
        else
            return false;

    }

    @Override
    public User selectUserByUserName(String userName) {
        return userDao.selectUserByUserName(userName);
    }

    @Override
    public boolean updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public boolean updateUserPwd(String userName, String password) {
        return userDao.updateUserPwd(userName,password);
    }

}
