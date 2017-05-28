package com.qust.controller;

import com.qust.domain.User;
import com.qust.service.IRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


/**
 * Created by Tan Weichao on 2017/4/13.
 */
@Controller
@EnableAutoConfiguration
public class HelloWorld {
    @Autowired
    private IRegService regService;

    @RequestMapping(value = "/love")
    public String love(){
        return "love";
    }

    @RequestMapping("/")
    String home(Model model) {
        List<User> users = regService.getUsers();
        model.addAttribute("users",users);
        return "index";
    }

    @RequestMapping("/reg")
    @ResponseBody
    Boolean reg(@RequestParam("loginPwd") String loginNum, @RequestParam("userId") String userId ){
        String pwd = creatMD5(loginNum);
        System.out.println(userId+":"+loginNum);
        regService.regUser(userId,pwd);
        return true;
    }

    private String creatMD5(String loginNum){
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(loginNum.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }
}
