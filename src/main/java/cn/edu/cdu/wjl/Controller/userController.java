package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.Utils.MD5Utils;
import cn.edu.cdu.wjl.Utils.MailUtil;
import cn.edu.cdu.wjl.service.userService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class userController {
    @Autowired
    userService userService;
    @Autowired
    MailUtil mailUtil;


    /**
     * 登录
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ModelAndView login(String name,String pwd,HttpServletRequest request,ModelAndView modelAndView){
        boolean result=userService.checkUserNameAndPwd(name,pwd);
        User user=userService.selectUserByUserName(name);
        HttpSession session=request.getSession();
        if (result) {
            session.setAttribute("userName", name);
            session.setAttribute("user",user);
            modelAndView.addObject("username",name);
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    /**
     * 注册
     * @param email
     * @param userName
     * @param password
     * @param modelAndView
     * @param request
     * @return
     */
    @RequestMapping("/regist")
    @ResponseBody
    public ModelAndView regist(@RequestParam String email,
                               @RequestParam String userName,
                               @RequestParam String password,
                               ModelAndView modelAndView,HttpServletRequest request){
        User user=new User();
        user.setUser_name(userName);
        user.setUser_pwd(password);
        user.setUser_email(email);
        request.getSession().setAttribute("userName",userName);
        userService.addUser(user);
        modelAndView.addObject("username",userName);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 检测用户名是否存在
     */
    @RequestMapping("/checkUserName")
    @ResponseBody
    public int checkUsername(String userName){
        if(userService.checkUserName(userName))
            return 0;
        else
            return 1;
    }

    /**
     * 检测邮箱是否存在
     */
    @RequestMapping("/checkEmail")
    @ResponseBody
    public int checkUEmail(String email){
        if(userService.checkEmail(email))
            return 0;
        else
            return 1;
    }



    /**
     * 获取用户信息
     */
    @RequestMapping("/userInfo")
    @ResponseBody
    public ModelAndView userInfo(ModelAndView modelAndView,HttpServletRequest request){
        String userName=(String)request.getSession().getAttribute("userName");
        User user=userService.selectUserByUserName(userName);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("userInformation");
        return modelAndView;
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public ModelAndView update(ModelAndView modelAndView,User user){
        if(userService.updateUserInfo(user)){
            modelAndView.addObject("user",user);
            modelAndView.addObject("message","修改成功");
            modelAndView.setViewName("userInformation");
        }else{
            modelAndView.setViewName("userInformation");
        }
        return modelAndView;
    }
    /**
     * 注销
     */
    @RequestMapping("/logout")
    @ResponseBody
    public ModelAndView logout(ModelAndView modelAndView,HttpServletRequest request){
        request.getSession().invalidate();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    /**
     * 邮箱验证码
     */
    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userName");
        String email = userService.selectUserByUserName(userName).getUser_email();
        String code = String.valueOf(new Random().nextInt(899999)+100000);
        String message = "您的验证码为："+code;
        try{
            mailUtil.sendCodetoMail(email,message);
            System.out.println("发送成功");

        }catch (Exception e){
            return "";
        }
        return code;
    }
    /**
     * 修改密码
     */
    @RequestMapping("/updateUserPwd")
    @ResponseBody
    public String updateUser(@RequestParam String newPwd,HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        try {
            String password = MD5Utils.setDBPwd(newPwd);
            System.out.println(password);
            userService.updateUserPwd(userName, password);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

}
