package cn.edu.cdu.wjl.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class pageController {

    @RequestMapping("/login1")
    public String login1(){
        return "login";
    }

    @RequestMapping("/goodInfo")
    public String goodInfo(){
        return "redirect:/getCatelogs";
    }

    @RequestMapping("/admin")
    public String adminLogin(){
        return "admin/login";
    }

}
