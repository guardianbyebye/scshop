package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.catelogDao;
import cn.edu.cdu.wjl.Entity.Catelog;
import cn.edu.cdu.wjl.service.catelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class catelogServiceImpl implements catelogService {
    @Autowired
    catelogDao catelogDao;

    @Override
    public List<Catelog> selectAllCatelogs() {
        return catelogDao.selectAllCatelogs();
    }

    @Override
    public boolean deleteCatelogById(int catelog_id) {
        return catelogDao.deleteCatelog(catelog_id);
    }

    @Override
    public boolean updateCatelog(Catelog catelog) {
        return catelogDao.updateCatelog(catelog);
    }

    @Override
    public boolean insertCatelog(Catelog catelog) {
        return catelogDao.insertCatelog(catelog);
    }

    @Override
    public Catelog selectCatelogByName(String catelog_name) {
        return catelogDao.selectCatelogByName(catelog_name);
    }
}
