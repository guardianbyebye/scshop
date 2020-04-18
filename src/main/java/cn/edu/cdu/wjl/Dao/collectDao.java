package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.LeftJoin;
import cn.edu.cdu.wjl.service.collectService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface collectDao {
    /**
     * 添加收藏
     */
    boolean addCollect(int good_id,int user_id);

    /**
     * 查找收藏的商品
     * @param collect_user_id
     * @return
     */
    List<LeftJoin> selectCollect(int collect_user_id);
    /**
     * 删除收藏夹商品
     */
    boolean deleteCollect(int good_id,int user_id);
}
