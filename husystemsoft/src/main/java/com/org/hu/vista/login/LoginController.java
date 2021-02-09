package com.org.hu.vista.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/login")
@RestController
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> obj=new HashMap<>();
        obj.put("tokenHead","Bearer");
//        obj.put("password","123");
        String code= (String) request.getSession().getAttribute("code");
        obj.put("code",code);
        obj.put("token","SXXXXXXXXXXXXXXXXXXXX");
        return obj;
    }
}
