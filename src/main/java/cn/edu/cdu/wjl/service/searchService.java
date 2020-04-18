package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.Entity.User;

import java.util.List;

public interface searchService {
    /**
     * 搜索商品
     */
    List<Good> selectGood(String good_name);
    /**
     * 搜索用户
     */
    List<User> selectUser(String user_name);
}
