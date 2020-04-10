package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.Gwc;
import cn.edu.cdu.wjl.Entity.LeftJoin;

import java.util.List;

public interface gwcService {
    /**
     * 添加商品到购物车
     */
    boolean addGoodsToGWC(Gwc gwc);
    /**
     * 查询购物车的商品
     */
    List<LeftJoin> selectByUserId(int gwc_user_id);
    /**
     * 删除购物车中商品
     */
    boolean deleteByGoodId(int good_id,int user_id);

}
