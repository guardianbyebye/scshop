package cn.edu.cdu.wjl.Controller;

import cn.edu.cdu.wjl.service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addressController {
    @Autowired
    addressService addressService;
    /**
     *添加地址
     */

}
