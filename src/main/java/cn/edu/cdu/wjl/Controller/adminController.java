package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.Catelog;
import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.service.adminService;
import cn.edu.cdu.wjl.Entity.Admin;
import cn.edu.cdu.wjl.service.catelogService;
import cn.edu.cdu.wjl.service.goodService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class adminController {
    @Autowired
    adminService adminService;
    @Autowired
    goodService goodService;
    @Autowired
    catelogService catelogService;


    /**
     * 登陆
     */

    @RequestMapping("/admin/login")
    public String adminLogin(String admin_name,String admin_pwd, HttpServletRequest request){
        boolean result=adminService.checkAdminPwd(admin_name,admin_pwd);
        Admin admin =adminService.selectAdminByName(admin_name);
        HttpSession session=request.getSession();
        if(result){
            session.setAttribute("admin",admin);
            return "redirect:/admin/index1";
        }else {
            return "admin/login";
        }
    }

    /**
     * 查询所有管理员
     * @param modelAndView
     * @return
     */
    @RequestMapping("/admin/index1")
    public ModelAndView index(ModelAndView modelAndView,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Admin> list = adminService.selectAllAdmin();
        PageInfo<Admin> pageInfo=new PageInfo<>(list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("list", list);
        modelAndView.setViewName("admin/index");

        return modelAndView;
    }
    /**
     * 新增管理员
     */
    @RequestMapping("/admin/update")
    public String addAdmin(Admin admin){

        if(0==admin.getAdmin_id()){
            adminService.addAdmin(admin);
        }else {
            adminService.updateAdmin(admin);
        }

        return "redirect:/admin/index1";
    }
    /**
     * 删除管理员
     */
    @RequestMapping("/admin/delete")
    public String deleteAdmin(int admin_id){
        adminService.deleteAdminById(admin_id);
        return "redirect:/admin/index1";
    }
    /**
     * 查询所有用户
     */
    @RequestMapping("/user/index")
    public ModelAndView userIndex(ModelAndView modelAndView,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        PageHelper.startPage(pageNum,5);
        List<User> list=adminService.selectAllUsers();
        PageInfo<User> pageInfo=new PageInfo<>(list);
        modelAndView.addObject("list",list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("admin/userInfo");
        return modelAndView;
    }

    /**
     * 删除用户
     */
    @RequestMapping("/user/delete")
    public String delete(int user_id){
        adminService.deleteUserById(user_id);
        return "redirect:/user/index";
    }

    /**
     * 查询所有商品
     */
    @RequestMapping("/good/index")
    public ModelAndView selectAllGoods(ModelAndView modelAndView,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Good> list=adminService.selectAllGoods();
        PageInfo<Good> pageInfo=new PageInfo<>(list);
        modelAndView.addObject("list",list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("admin/goods");
        return modelAndView;
    }
    /**
     * 删除商品
     */
    @RequestMapping("/good/delete")
    public String goodDelete(int good_id){
        goodService.deleteGoodById(good_id);
        return "redirect:/good/index";
    }

    /**
     * 管理员查询所有分类
     */
    @RequestMapping("/catelog/index")
    public ModelAndView allCatelog(ModelAndView modelAndView,
                                   @RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Catelog> list=catelogService.selectAllCatelogs();
        PageInfo<Catelog> pageInfo=new PageInfo<>(list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("admin/catelog");
        return modelAndView;
    }

    /**
     * 删除分类
     */
    @RequestMapping("/catelog/delete")
    public String catelogDelete(int catelog_id){
        catelogService.deleteCatelogById(catelog_id);
        return "redirect:/catelog/index";
    }

    /**
     * 增加/更新分类
     */
    @RequestMapping("/catelog/update")
    public String update(Catelog catelog){

        if(0 == catelog.getCatelog_id()){
            catelogService.insertCatelog(catelog);
        }else{
            catelogService.updateCatelog(catelog);
        }

        return "redirect:/catelog/index";
    }
}
