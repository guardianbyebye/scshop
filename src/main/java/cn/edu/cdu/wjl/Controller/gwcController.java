package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.Gwc;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.service.gwcService;
import cn.edu.cdu.wjl.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class gwcController {
    @Autowired
    gwcService gwcService;
    @Autowired
    userService userService;
    /**
     * 查看购物车
     */
    @RequestMapping("/shoppingCart")
    public String shoppingCart(){
        return "shoppingCart";
    }
    /**
     * 添加商品到购物车
     */
    @RequestMapping("/addGoodToGWC")
    public String addToGWC(@RequestParam(defaultValue = "1") int good_number, int good_id,int good_user_id, Gwc gwc, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        User user = userService.selectUserByUserName(userName);
        if(good_user_id==user.getUser_id()){
            return "redirect:/";
        }
        gwc.setGwc_user_id(user.getUser_id());
        gwc.setGwc_good_id(good_id);
        gwc.setGwc_good_number(good_number);
        gwcService.addGoodsToGWC(gwc);

            return "redirect:/shoppingCart";


    }
}
