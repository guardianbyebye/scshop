package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.gwcDao;
import cn.edu.cdu.wjl.Entity.Gwc;
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
    public List<Gwc> selectByUserId(int good_user_id) {
        return null;
    }
}
