package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.LeftJoin;

import java.util.List;

public interface collectService {
    /**
     * 添加到收藏
     */
    boolean addToCollect(int good_id,int user_id);
    /**
     * 查找收藏商品
     */
    List<LeftJoin> selectCollect(int collect_user_id);
    /**
     * 删除收藏夹商品
     */
    boolean deleteCollect(int good_id,int user_id);
}
