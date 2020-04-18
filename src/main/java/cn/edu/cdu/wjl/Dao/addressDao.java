package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface addressDao {
    boolean insertAddress(Address address);

    boolean updateAddress(Address address);

    Address selectAddressByUserId(int user_id);
}
