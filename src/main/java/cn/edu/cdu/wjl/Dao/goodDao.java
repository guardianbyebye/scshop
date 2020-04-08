package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface goodDao {
    /**
     * 添加新商品
     */
    boolean insertGood(Good good);
    /**
     * 获取自己发布的商品
     */
    List<Good> findGoodByUserId(int user_id);
    /**
     * 根据id查询商品
     */
    Good selectGoodByGoodId(int good_id);
    /**
     * 修改商品信息
     */
    boolean updateGoodInfoByGoodId(Good good);
    /**
     *查询所有商品
     */
    List<Good> selectAllGoods();
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
     * 查询上架中的商品
     */
    List<Good> goodStatus0();
}
