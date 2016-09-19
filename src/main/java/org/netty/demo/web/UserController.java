package org.netty.demo.web;

import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.netty.demo.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/netty")
	public String demoNetty(String name) {
		System.out.println(name);
		return "";
	}

	
	@RequestMapping(value="/param")
	@ResponseBody
	public ResponseEntity param(String name) {
		System.out.println(name);
		return BaseResponse.buildSuccess(name, "请求成功");
	}
	
	
	@RequestMapping(value="/json")
	@ResponseBody
	public ResponseEntity paramsJson(@RequestBody UserDto dto) {
		System.out.println(dto);
		return BaseResponse.buildSuccess(dto, "请求成功");
	}
	
	@RequestMapping(value="/dto")
	@ResponseBody
	public ResponseEntity paramsDto(UserDto dto) {
		System.out.println(dto);
		return BaseResponse.buildSuccess(dto, "请求成功");
	}
}
