package com.org.hu.vista.login;

import com.org.hu.vista.utils.VerifyCodeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RequestMapping("/captche")
@RestController
public class GetCaptche {
    @RequestMapping(value = "/getCaptche",method = RequestMethod.GET)
    public void createCaptche(HttpServletRequest request, HttpServletResponse response){
        System.out.println("---进入---");
        Map<String,Object> map=new HashMap<>();
        String valityCode=VerifyCodeUtils.generateVerifyCode(4);
        request.getSession().setAttribute("code",valityCode);
        // 生成图片
        int w = 100, h = 30;
        try {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), valityCode);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
