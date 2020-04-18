package cn.edu.cdu.wjl.service.impl;


import cn.edu.cdu.wjl.Dao.orderDao;
import cn.edu.cdu.wjl.Entity.Order;
import cn.edu.cdu.wjl.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderServiceImpl implements orderService {
    @Autowired
    orderDao orderDao;

    @Override
    public boolean insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }
}
