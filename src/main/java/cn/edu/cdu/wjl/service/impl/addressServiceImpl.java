package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.addressDao;
import cn.edu.cdu.wjl.Entity.Address;
import cn.edu.cdu.wjl.service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addressServiceImpl implements addressService {
    @Autowired
    addressDao addressDao;
    @Override
    public boolean insertAddress(Address address) {
        return addressDao.insertAddress(address);
    }

    @Override
    public boolean updateAddress(Address address) {
        return addressDao.updateAddress(address);
    }

    @Override
    public Address selectAddressByUserId(int user_id) {
        return addressDao.selectAddressByUserId(user_id);
    }
}
