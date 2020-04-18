package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.collectDao;
import cn.edu.cdu.wjl.Entity.LeftJoin;
import cn.edu.cdu.wjl.service.collectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class collectServiceImpl implements collectService {
    @Autowired
    collectDao collectDao;
    @Override
    public boolean addToCollect(int good_id, int user_id) {
        return collectDao.addCollect(good_id,user_id);
    }

    @Override
    public List<LeftJoin> selectCollect(int collect_user_id) {
        return collectDao.selectCollect(collect_user_id);
    }

    @Override
    public boolean deleteCollect(int good_id, int user_id) {
        return collectDao.deleteCollect(good_id,user_id);
    }
}
