package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Gwc;
import cn.edu.cdu.wjl.Entity.LeftJoin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface gwcDao {

     boolean addGoodToGWC(Gwc gwc);

     List<LeftJoin> selectByUserId(int good_user_id);
}
