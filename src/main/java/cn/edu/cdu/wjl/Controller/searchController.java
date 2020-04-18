package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.service.searchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class searchController {
    @Autowired
    searchService searchService;

    /**
     * 搜索
     */
    @RequestMapping("/searchGood")
    public ModelAndView searchGood(ModelAndView modelAndView, String goodName,int optionValue){
        if(optionValue==1) {
            List<Good> list = searchService.selectGood(goodName);
            modelAndView.addObject("list", list);
            modelAndView.setViewName("search");
            return modelAndView;
        }else {
            List<User> list=searchService.selectUser(goodName);
            modelAndView.addObject("list", list);
            modelAndView.setViewName("searchUser");
            return modelAndView;
        }

    }
}
