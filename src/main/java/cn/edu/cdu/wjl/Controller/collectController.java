package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.LeftJoin;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.service.collectService;
import cn.edu.cdu.wjl.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class collectController {
    @Autowired
    collectService collectService;
    @Autowired
    userService userService;
    /**
     * 添加收藏
     */
    @RequestMapping("/addCollect")
    public String addCollect(int good_id, HttpSession session){
        String userName = (String) session.getAttribute("userName");
        User user = userService.selectUserByUserName(userName);
        int user_id=user.getUser_id();
        collectService.addToCollect(good_id,user_id);
        return "redirect:/collect";
    }
    /**
     * 查看收藏
     */
    @RequestMapping("/collect")
    public ModelAndView collect(ModelAndView modelAndView,HttpSession session){
        String userName = (String) session.getAttribute("userName");
        User user = userService.selectUserByUserName(userName);
        int user_id=user.getUser_id();
        List<LeftJoin> list=collectService.selectCollect(user_id);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("collect");
        return modelAndView;
    }
    /**
     * 删除收藏夹的商品
     */
    @RequestMapping("/deleteCollect")
    public String deleteCollect(HttpSession session,int good_id){
        String userName = (String) session.getAttribute("userName");
        User user = userService.selectUserByUserName(userName);
        Integer user_id=user.getUser_id();
        collectService.deleteCollect(good_id,user_id);
        return "redirect:/collect";
    }
}
