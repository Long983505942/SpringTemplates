package com.itheima.mm.controller;

import com.itheima.mm.entity.Result;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;
import com.itheima.mm.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserConstroller {
    private UserService userService=new UserService();
    @RequestMapping("/user/init")
    public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = JsonUtils.parseJSON2Object(request, User.class);
            User user1 = userService.init(user);
            if (user1!=null){
                request.getSession().setAttribute("loginUser", user1);
                JsonUtils.printResult(response,new Result(true,"登录失败"));
            }else{
                JsonUtils.printResult(response,new Result(false,"登陆失败"));
            }
        } catch (Exception e) {
            JsonUtils.printResult(response,new Result(false,"登陆失败"));
            e.printStackTrace();
        }
    }
}
