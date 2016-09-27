package org.netty.demo.controller;

import org.framework.basic.constant.Constants;
import org.framework.basic.system.BaseException;
import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.netty.demo.entity.User;
import org.netty.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {



    @Resource
    private UserService userService;

    /*@RequestMapping
    public String index() {
        return "add";
    }*/

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity insert(@RequestBody User u) {
        try {
            userService.insert(u);
            return BaseResponse.buildSuccess("添加成功");
        } catch (Exception e) {
            return BaseResponse.buildError(e.getMessage(), "添加失败");
        }
    }

    //分页
    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity insert(Integer pageStar, Integer pageSize) {
        try {
            List<User> users = userService.selectAll(pageStar, pageSize);
            return BaseResponse.buildSuccess(users);
        } catch (Exception e) {
            return BaseResponse.buildError(e.getMessage(), "添加失败");
        }
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody User u, Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            userService.update(u);
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }
        model.addAttribute("resp", resp);
        return "add";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(String id, Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            userService.deleteById(id);
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }
        model.addAttribute("resp", resp);
        return "add";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            List<User> userList = userService.getAll();
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
            resp.setData(userList);
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }

        model.addAttribute("resp", resp);
        return "add";
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public String getOne(String id, Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            User u = userService.getById(id);
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
            resp.setData(u);
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }
        model.addAttribute("resp", resp);
        return "add";
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public String getOne(Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            userService.deleteAll();
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }
        model.addAttribute("resp", resp);
        return "add";
    }

    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.GET)
    public String deleteByPrimaryKey(User u, Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            userService.delete(u);
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }
        model.addAttribute("resp", resp);
        return "add";
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    public String queryById(String id, Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            User u = userService.queryById(id);
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
            resp.setData(u);
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }
        model.addAttribute("resp", resp);
        return "add";
    }

    @RequestMapping(value = "/queryBitById", method = RequestMethod.GET)
    public String queryBItById(String id, Model model) {
        ResponseEntity resp = new ResponseEntity();
        try {
            User u = userService.queryBitById(id);
            resp.setStatus(Constants.System.SUCCESSS);
            resp.setMessage("添加用户成功");
            resp.setData(u);
        } catch (BaseException e) {
            resp.setStatus(Constants.System.ERROR);
            resp.setError("添加用出错，数据库操作失败");

        }
        model.addAttribute("resp", resp);
        return "add";
    }


	
	
	@RequestMapping(value = "/test")
	public void test(String name) {
		System.out.println(name);
	}
	
    @RequestMapping(value = "/netty")
    public String demoNetty(Model model, String name) {
        System.out.println(name);
        
        model.addAttribute("name", name);
        return "index";
    }



}
