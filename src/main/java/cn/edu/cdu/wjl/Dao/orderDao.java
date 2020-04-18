package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface orderDao {
    boolean insertOrder(Order order);
}
