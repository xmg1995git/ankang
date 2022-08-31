package com.duanwu.ankang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("test")
public class ForwardController
{
    @ResponseBody
    @GetMapping("s1")
    public String say1(){
        return "say1...";
    }

    @ResponseBody
    @GetMapping("s2")
    public String say2(){
        return "say2...";
    }

    @GetMapping("s")
    public String s(){
        return "forward:/test/s1";
    }


    @GetMapping("sss")
    public void sss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/test/s1").forward(request, response);
    }

    @GetMapping("ss")
    public String ss(RedirectAttributes attributes){
        attributes.addAttribute("attributes", "attributes");
        return "redirect:/test/s2";
    }
}
