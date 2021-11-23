package com.studyproject.controller;

import com.studyproject.dto.UserDTO;
import com.studyproject.service.BoardService;
import com.studyproject.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource(name = "defaultLoginService")
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserDTO user) {
        String resultValue = loginService.login(user);

        if (resultValue.equals("false")) {
           return "false";
        }

        return  user.getId();
    }
}
