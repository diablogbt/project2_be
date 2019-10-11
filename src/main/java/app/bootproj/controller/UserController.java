package app.bootproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.bootproj.config.JwtTokenUtil;
import app.bootproj.pojo.UserInfo;
import app.bootproj.service.UserService;

/**
 * UserController
 */
@RestController
@Validated
@CrossOrigin
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;
    

    @GetMapping("/getUser")
    Integer getUser(@RequestParam String uname, @RequestParam String pwd){
        UserInfo userinfo=userService.get(uname, pwd);
        if(userinfo != null)return userinfo.getUserid();
        else
        return null;
    }

    @GetMapping("/getUserById")
    UserInfo getUser(@RequestParam Integer userId){
        UserInfo userinfo=userService.get(userId);
        if(userinfo!=null)
            return userinfo;
        else
            return null;
    }

    @GetMapping("/getAll")
    ResponseEntity<?> getUser(){
        List<UserInfo> userinfoList=userService.getAll();
        return ResponseEntity.ok().body(userinfoList);
    }
}