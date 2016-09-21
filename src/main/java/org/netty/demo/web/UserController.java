package org.netty.demo.web;

import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.netty.demo.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping(value = "/test")
	public void test(String name) {
		System.out.println(name);
	}

    @RequestMapping(value = "/netty")
    public String demoNetty(String name) {
        System.out.println(name);
        return "";
    }


    @RequestMapping(value = "/param")
    @ResponseBody
    public ResponseEntity param(String name) {
        System.out.println(name);
        return BaseResponse.buildSuccess(name, "请求成功");
    }


    @RequestMapping(value = "/json")
    @ResponseBody
    public ResponseEntity paramsJson(@RequestBody UserDto dto) {
        System.out.println(dto);
        return BaseResponse.buildSuccess(dto, "请求成功");
    }

    @RequestMapping(value = "/dto")
    @ResponseBody
    public ResponseEntity paramsDto(UserDto dto) {
        System.out.println(dto);
        return BaseResponse.buildSuccess(dto, "请求成功");
    }


    /**
     * 上传资源文件
     * @param
     * @return
     */
    @RequestMapping(value="/uploadFile", method= RequestMethod.POST)
    @ResponseBody
    public ResponseEntity uploadFile(@RequestParam(value="file", required=true) MultipartFile file) throws IOException {

        //@RequestParam(value="file", required=true) MultipartFile file   HttpServletRequest request
        /**
         * springMvc做文件上传有两种方式：
         * 1,现在用的这种方式
         * 2,下面注释的两行代码的方式
         */
        //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //MultipartFile file = multipartRequest.getFile("file");
        ResponseEntity resp = new ResponseEntity();
        String contentType = file.getContentType();
        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        InputStream inputStream = file.getInputStream();
        return resp;
    }

    /**
     * 下载
     * @param req
     * @param resp
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void exportCreditAssignment(HttpServletRequest req, HttpServletResponse resp) {
        //以下2行代码解决跨源问题
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
        HashMap<String, Object> map = new HashMap<String, Object>();

        resp.setContentType("application/vnd.ms-word;charset=UTF-8");

        String agent = req.getHeader("User-Agent");

        resp.setHeader("Content-Disposition", "attachment;filename=");
        try {
            ServletOutputStream stream = resp.getOutputStream();
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
