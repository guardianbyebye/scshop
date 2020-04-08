package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.Gwc;

import java.util.List;

public interface gwcService {
    /**
     * 添加商品到购物车
     */
    boolean addGoodsToGWC(Gwc gwc);
    /**
     * 查询购物车的商品
     */
    List<Gwc> selectByUserId(int good_user_id);
}
