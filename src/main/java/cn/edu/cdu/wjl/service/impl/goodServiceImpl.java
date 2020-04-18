package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.goodDao;
import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.service.goodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class goodServiceImpl implements goodService {

    @Autowired
    goodDao goodDao;
    @Override
    public boolean addGoods(Good good) {
        return goodDao.insertGood(good);
    }

    @Override
    public List<Good> getOwnGoods(int user_id) {
        return goodDao.findGoodByUserId(user_id);
    }

    @Override
    public Good getGoodDetails(int good_id) {
        return goodDao.selectGoodByGoodId(good_id);
    }

    @Override
    public boolean updateGoodInfo(Good good) {
        return goodDao.updateGoodInfoByGoodId(good);
    }

    @Override
    public List<Good> allGoods() {
        return goodDao.selectAllGoods();
    }

    @Override
    public boolean deleteGoodById(int good_id) {
        return goodDao.deleteGoodById(good_id);
    }

    @Override
    public boolean shangjia(int good_id) {
        return goodDao.shangjia(good_id);
    }

    @Override
    public boolean xiajia(int good_id) {
        return goodDao.xiajia(good_id);
    }

    @Override
    public List<Good> goodStatus0() {
        return goodDao.goodStatus0();
    }

    @Override
    public boolean isRecommend(int good_id) {
        return goodDao.isRecommend(good_id);
    }

    @Override
    public boolean notRecommend(int good_id) {
        return goodDao.notRecommend(good_id);
    }

    @Override
    public List<Good> selectRecommendGood() {
        return goodDao.recommendGoods();
    }


}
