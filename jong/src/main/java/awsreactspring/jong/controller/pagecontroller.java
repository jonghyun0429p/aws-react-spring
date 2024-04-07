package awsreactspring.jong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import awsreactspring.jong.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class pagecontroller {

    private final UserService userService;

    @Autowired
    public pagecontroller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/test")
    public String hello() {
        return "테스트아님니다.";
    }

    @ResponseBody
    @PostMapping("/api/join")
    public String UserJoin(@RequestBody String entity) {
        System.out.println(entity);
        System.out.println(entity.getClass().getName());
        return "데이터 받기 성공";
    }

    @PostMapping("/api/login")
    public String UserLogin(@RequestBody String entity) {
        return "";
    }
    

    @GetMapping("/")
    public String home() {
        return "new! 메인페이지";
    }
}
