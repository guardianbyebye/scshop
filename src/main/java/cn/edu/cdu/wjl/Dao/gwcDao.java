package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Gwc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface gwcDao {

     boolean addGoodToGWC(Gwc gwc);

     List<Gwc> selectByUserId(int good_user_id);
}
