package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.Message;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.service.messageService;
import cn.edu.cdu.wjl.service.userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;


@Controller
public class messageController {
    @Autowired
    messageService messageService;
    @Autowired
    userService userService;
    /**
     * 新增留言
     */
    @RequestMapping("/addMessage")
    public String addMessage(HttpSession session, String message_text,int message_good_id,
                             String message_user_name,Message message,RedirectAttributes redirectAttributes){
        String userName=(String)session.getAttribute("userName");
        User user=userService.selectUserByUserName(userName);
        message.setMessage_user_id(user.getUser_id());
        message.setMessage_good_id(message_good_id);
        message.setMessage_texts(message_text);
        message.setMessage_time(new Date());
        message.setMessage_user_name(message_user_name);
        messageService.addMessage(message);
        redirectAttributes.addAttribute("good_id",message_good_id);
        return "redirect:/showGoodDetails";
    }
    /**
     * 全部留言
     */
    @RequestMapping("/message/index")
    public ModelAndView messageIndex(ModelAndView modelAndView,@RequestParam(defaultValue = "1",value = "pageNum") int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Message> list=messageService.getAllMessages();
        PageInfo<Message> pageInfo=new PageInfo<>(list);
        modelAndView.addObject("list",list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("admin/messages");
        return modelAndView;
    }
    /**
     * 删除留言
     */
    @RequestMapping("/message/delete")
    public String deleteMessage(int message_id){
        messageService.deleteMessage(message_id);
        return "redirect:/message/index";
    }
}
