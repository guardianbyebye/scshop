package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.goodDao;
import cn.edu.cdu.wjl.Dao.userDao;
import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.service.searchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class searchServiceImpl implements searchService {
    @Autowired
    goodDao goodDao;
    @Autowired
    userDao userDao;
    @Override
    public List<Good> selectGood(String good_name) {
        return goodDao.selectGood(good_name);
    }

    @Override
    public List<User> selectUser(String user_name) {
        return userDao.selectUser(user_name);
    }
}
