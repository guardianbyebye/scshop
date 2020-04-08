package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.Catelog;
import cn.edu.cdu.wjl.service.catelogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class catelogController {
    @Autowired
    catelogService catelogService;

    /**
     * 查询所有分类
     */
    @RequestMapping("/getCatelogs")
    public ModelAndView getCatelogs(ModelAndView modelAndView){
        List<Catelog> list=catelogService.selectAllCatelogs();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("goodInfo");
        return modelAndView;
    }
}
