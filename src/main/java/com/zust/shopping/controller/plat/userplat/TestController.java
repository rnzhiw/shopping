package com.zust.shopping.controller.plat.userplat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("hello")
    public String hello() {
        return "/userplat/test";
    }
}

