package com.zust.shopping.controller.api;

import com.zust.shopping.common.LoginException;
import com.zust.shopping.model.domain.Sysuser;
import com.zust.shopping.model.dto.LoginDTO;
import com.zust.shopping.model.dto.TestDTO;
import com.zust.shopping.service.SysuserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 登录api控制器
 */
@Controller
@RequestMapping("/userplat")
public class LoginController {

    @Autowired
    private SysuserService sysuserService;

    /**
     * 登录
     * @param loginName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String loginName,String password,HttpSession session) {

        TestDTO testDTO = new TestDTO();
        testDTO.setId((long)1);
        testDTO.setName("哈哈哈");
        testDTO.setAge(99);
        testDTO.setPassword("123456");

        try {
            //把断点打在可能会出问题的地方，可以查看对应的参数值
            LoginDTO sysuser = sysuserService.getSysuserByLoginNameAndPassword(loginName, password);
            session.setAttribute("sysuser",sysuser);
            return "/userplat/main";
        } catch (LoginException e) {
            e.printStackTrace();
            return "/userplat/login";
        }
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(HttpSession session) {
        session.invalidate();
        return "/userplat/login";
    }


    @RequestMapping("/register")
    public String register() {
        return "/userplat/register";
    }


    /**
     * 测试接收form表单、URL的数据。不能接收Json数据
     * */
    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    @ResponseBody
    public String formData(@RequestParam("name") String name , @RequestParam("age") int age){
        String result = "receive name = "+name+" age = "+age;
        System.out.println(result);
        return result;
    }

    /**
     * 测试动态接收URL中的数据
     * */
    @RequestMapping(value = "/test2/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @ResponseBody
    public String urlData(@PathVariable int pageNo , @PathVariable int pageSize){
        String result = "receive pageNo = "+pageNo+" pageSize = "+pageSize;
        System.out.println(result);
        return result;
    }

    /**
     * 测试json传参
     */
    @RequestMapping("/test3")
    @ResponseBody
    public String test3(@RequestBody Sysuser sysuser) {

        String result = "recieve:" + sysuser.getName() + sysuser.getPassword();
        System.out.println(result);
        return result;
    }



}