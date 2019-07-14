package com.zust.shopping.controller.plat.userplat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入口控制器
 *
 * @author ruanzhiwei
 * @date 2019/7/7
 */
@Controller
@RequestMapping("/userplat")
public class MainController {

    /**
     * 管理端主页面
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "/userplat/main";
    }

    /**
     * 切换商品类型管理界面
     * @return
     */
    @RequestMapping("/productTypeManager")
    public String productTypeManager() {
        return "/userplat/productTypeManager";
    }

    /**
     * 切换商品管理界面
     * @return
     */
    @RequestMapping("/productManager")
    public String productManager() {
        return "/userplat/productManager";
    }

    /**
     * 切换客户管理界面
     * @return
     */
    @RequestMapping("/customerManager")
    public String customerManager() {
        return "/userplat/customerManager";
    }

    /**
     * 切换系统用户管理界面
     * @return
     */
    @RequestMapping("/sysuserManager")
    public String sysuserManager() {
        return "/userplat/sysuserManager";
    }



}
