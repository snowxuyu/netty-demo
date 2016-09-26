package org.netty.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping(value = "/test")
	public void test(String name) {
		System.out.println(name);
	}
	
	//没有设置视图解析器  会出错
    @RequestMapping(value = "/netty")
    public String demoNetty(String name) {
        System.out.println(name);
        return "";
    }



}
