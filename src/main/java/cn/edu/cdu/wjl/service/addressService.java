package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.Address;

public interface addressService {
    /**
     * 添加地址
     */
    boolean insertAddress(Address address);
    /**
     * 修改地址
     */
    boolean updateAddress(Address address);
    /**
     * 查询
     */
    Address selectAddressByUserId(int user_id);
}
