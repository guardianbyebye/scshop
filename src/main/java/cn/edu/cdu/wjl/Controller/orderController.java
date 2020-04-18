package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.*;
import cn.edu.cdu.wjl.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class orderController {
    @Autowired
    catelogService catelogService;
    @Autowired
    addressService addressService;
    @Autowired
    userService userService;
    @Autowired
    orderService orderService;
    @Autowired
    goodService goodService;
    /**
     *创建订单
     */
    @RequestMapping("/orderCreate")
    public ModelAndView createOrder(ModelAndView modelAndView, HttpSession session, int good_id, Order order,@RequestParam(defaultValue = "1") int buy_number){

        String userName = (String) session.getAttribute("userName");
        User user = userService.selectUserByUserName(userName);
        Address address=addressService.selectAddressByUserId(user.getUser_id());
        List<Catelog> catelogs=catelogService.selectAllCatelogs();
        Good good=goodService.getGoodDetails(good_id);
        int goodPrice = Integer.parseInt(String.valueOf(good.getGood_price()));
        int totalPrice=goodPrice*buy_number;
        String order_n=UUID.randomUUID()+"1";
        order.setOrder_user_id(user.getUser_id());
        order.setOrder_good_id(good_id);
        order.setCreate_time(new Date());
        order.setOrder_number(order_n);
        order.setBuy_number(buy_number);
        orderService.insertOrder(order);
        modelAndView.addObject("totalPrice",totalPrice);
        modelAndView.addObject("buyNumber",buy_number);
        modelAndView.addObject("good",good);
        modelAndView.addObject("catelogs",catelogs);
        modelAndView.addObject("address",address);
        modelAndView.setViewName("checkout");
        return modelAndView;
    }
    /**
     * 支付
     */
    @RequestMapping("/orderPay")
    public ModelAndView pay(ModelAndView modelAndView, Address address, String real_name, String phone, String address_name, HttpSession session){
        String userName = (String) session.getAttribute("userName");
        User user = userService.selectUserByUserName(userName);
        Address ad=addressService.selectAddressByUserId(user.getUser_id());
        address.setUser_id(user.getUser_id());
        address.setAddress_name(address_name);
        address.setPhone(phone);
        address.setReal_name(real_name);
        if(ad==null){
            addressService.insertAddress(address);
            modelAndView.setViewName("checkout");
        }else{
            addressService.updateAddress(address);
            modelAndView.setViewName("checkout");
        }
        return modelAndView;
    }


}
