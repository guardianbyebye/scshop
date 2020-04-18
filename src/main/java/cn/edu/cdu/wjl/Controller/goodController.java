package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.Entity.Catelog;
import cn.edu.cdu.wjl.Entity.Good;
import cn.edu.cdu.wjl.Entity.Message;
import cn.edu.cdu.wjl.Entity.User;
import cn.edu.cdu.wjl.Utils.FileUtils;
import cn.edu.cdu.wjl.service.catelogService;
import cn.edu.cdu.wjl.service.goodService;
import cn.edu.cdu.wjl.service.messageService;
import cn.edu.cdu.wjl.service.userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class goodController {
    @Autowired
    goodService goodService;
    @Autowired
    userService userService;
    @Autowired
    catelogService catelogService;
    @Autowired
    messageService messageService;
    /**
     * 发布新商品
     * @param file
     * @param request
     * @param goodName
     * @param goodPrice
     * @param goodNum
     * @param goodDes
     * @param modelAndView
     * @return
     */
    @RequestMapping("/insertNewGood")
    public ModelAndView upload(@RequestParam("file")MultipartFile file, HttpServletRequest request,
                         String goodName,String goodPrice,int goodNum,String goodDes,ModelAndView modelAndView,int catelog_id) throws IOException {
        if(file.isEmpty()){
            throw new NullPointerException("文件为空");
        }
        String filePath = "D:/java2/scshop/src/main/resources/static/assets/images";
        //获取原始图片的拓展名
        String originalFileName = file.getOriginalFilename();
        //新的文件名
        String newFileName = UUID.randomUUID() + originalFileName;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);

        Good good=new Good();
        good.setGood_name(goodName);
        good.setGood_price(goodPrice);
        good.setGood_number(goodNum);
        good.setGood_description(goodDes);
        good.setGood_photo(newFileName);
        good.setGood_catelog_id(catelog_id);
        String userName=(String) request.getSession().getAttribute("userName");
        User user=userService.selectUserByUserName(userName);
        good.setGood_user_id(user.getUser_id());
        goodService.addGoods(good);
        modelAndView.setViewName("redirect:/getOwnGoods");
        return  modelAndView;
    }
    /**
     * 查看已发布商品
     */
    @RequestMapping("/getOwnGoods")
    public ModelAndView getGoods(ModelAndView modelAndView,HttpServletRequest request,Good good){
        String userName=(String)request.getSession().getAttribute("userName");
        User user=userService.selectUserByUserName(userName);
        good.setGood_user_id(user.getUser_id());
        List<Good> goods=goodService.getOwnGoods(good.getGood_user_id());
        System.out.println(goods);
        modelAndView.addObject("user",user);
        modelAndView.addObject("goods",goods);
        modelAndView.setViewName("listproducts");
        return modelAndView;
    }
    /**
     * 查看商品详情
     */
    @RequestMapping("/showGoodDetails")
    public ModelAndView showDetails(ModelAndView modelAndView,@RequestParam int good_id,HttpServletRequest request,Good good){
        request.getSession().setAttribute("good_id",good_id);
        good=goodService.getGoodDetails(good_id);
        List<Message> message=messageService.selectMessage(good_id);
        modelAndView.addObject("message",message);
        modelAndView.addObject("good",good);
        modelAndView.setViewName("productdetails");
        return modelAndView;
    }
    /**
     * 修改商品信息页面
     */
    @RequestMapping("/updateGoodInfo")
    public ModelAndView updateGood(ModelAndView modelAndView,@RequestParam int good_id,HttpServletRequest request,Good good) {
        request.getSession().setAttribute("good_id2",good_id);
        good=goodService.getGoodDetails(good_id);
        modelAndView.addObject("good",good);
        modelAndView.setViewName("updateGoodInfo");
        return modelAndView;
    }
    /**
     * 修改商品信息
     */
    @RequestMapping("/updateGoodInfoById")
    public ModelAndView update(ModelAndView modelAndView,Good good){
        if(goodService.updateGoodInfo(good)){
            modelAndView.addObject("good",good);
            modelAndView.setViewName("productdetails");
            return modelAndView;
        }else{
            modelAndView.setViewName("404page");
            return modelAndView;
        }

    }
    /**
     * 查询所有商品
     */
    @RequestMapping("/")
    public ModelAndView getAllGoods(@RequestParam(defaultValue = "1")int pageNum,
                                    ModelAndView modelAndView,HttpServletRequest request){
        List<Catelog> catelogs=catelogService.selectAllCatelogs();
        List<Good> rList=goodService.selectRecommendGood();
        PageHelper.startPage(pageNum,8);
        List<Good> list=goodService.allGoods();
        PageInfo<Good> pageInfo=new PageInfo<>(list);
        modelAndView.addObject("list",list);
        modelAndView.addObject("rList",rList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("catelogs",catelogs);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    /**
     * 上架商品
     */
    @RequestMapping("/good/shangjia")
    public String shangjia(int good_id){
        goodService.shangjia(good_id);
        return "redirect:/good/index";
    }
    /**
     * 下架
     */
    @RequestMapping("/good/xiajia")
    public String xiajia(int good_id){
        goodService.xiajia(good_id);
        return "redirect:/good/index";
    }

    /**
     * 所有已上架商品商品
     */
    @RequestMapping("/allGoods")
    public ModelAndView allgoods(ModelAndView modelAndView,@RequestParam(defaultValue = "1")int pageNum){
        List<Catelog> catelogs=catelogService.selectAllCatelogs();
        PageHelper.startPage(pageNum,12);
        List<Good> list=goodService.goodStatus0();
        PageInfo<Good> pageInfo=new PageInfo<>(list);
        modelAndView.addObject("catelogs",catelogs);
        modelAndView.addObject("list",list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("allGoods");
        return modelAndView;
    }
    /**
     * 推荐商品
     */
    @RequestMapping("/good/isRecommend")
    public String isRecommend(int good_id){
        goodService.isRecommend(good_id);
        return "redirect:/good/index";
    }
    /**
     * 更改商品为不推荐商品
     */
    @RequestMapping("/good/notRecommend")
    public String notRecommend(int good_id){
        goodService.notRecommend(good_id);
        return "redirect:/good/index";
    }
    /**
     * 根据用户id查询商品
     */
     @RequestMapping("/selectUserGood")
    public ModelAndView selectUserGood(ModelAndView modelAndView, int user_id, HttpSession session){
         String userName=(String)session.getAttribute("userName");
         User user=userService.selectUserByUserName(userName);
         List<Good> list=goodService.getOwnGoods(user_id);
         modelAndView.addObject("user",user);
         modelAndView.addObject("goods",list);
         modelAndView.setViewName("listproducts");
         return modelAndView;
     }
}
