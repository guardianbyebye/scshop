package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.gwcDao;
import cn.edu.cdu.wjl.Entity.Gwc;
import cn.edu.cdu.wjl.Entity.LeftJoin;
import cn.edu.cdu.wjl.service.gwcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class gwcServiceImpl implements gwcService {

    @Autowired
    gwcDao gwcDao;
    @Override
    public boolean addGoodsToGWC(Gwc gwc) {
        return gwcDao.addGoodToGWC(gwc);
    }

    @Override
    public List<LeftJoin> selectByUserId(int gwc_user_id) {
        return gwcDao.selectByUserId(gwc_user_id);
    }

    @Override
    public boolean deleteByGoodId(int good_id,int user_id) {
        return gwcDao.deleteByGoodId(good_id,user_id);
    }
}
