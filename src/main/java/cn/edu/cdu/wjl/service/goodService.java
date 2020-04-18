package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.Good;

import java.util.List;

public interface goodService {
    /**
     * 新增商品
     * @param good
     * @return
     */
    boolean addGoods(Good good);
    /**
     * 用户查看已发布商品
     */
    List<Good> getOwnGoods(int user_id);
    /**
     * 查询商品详细信息
     */
    Good getGoodDetails(int good_id);
    /**
     * 修改商品信息
     */
    boolean updateGoodInfo(Good good);
    /**
     * 查询所有商品
     */
    List<Good> allGoods();
    /**
     * 删除商品
     */
    boolean deleteGoodById(int good_id);
    /**
     * 上架商品
     */
    boolean shangjia(int good_id);
    /**
     * 下架商品
     */
    boolean xiajia(int good_id);
    /**
     * 查询上架中商品
     */
    List<Good> goodStatus0();
    /**
     * 更改为推荐商品
     */
    boolean isRecommend(int good_id);
    /**
     * 更改为不推荐
     */
    boolean notRecommend(int good_id);
    /**
     * 查询推荐商品
     */
    List<Good> selectRecommendGood();

}
