package com.duanwu.ankang.controller;

import com.duanwu.ankang.mode.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@ResponseBody
public class HelloController {


    @GetMapping("/")
    public String hello2(){
        return "Hello Springboot!";
    }


    @PostMapping("/helloId")
    public String helloId(){
        return "Hello Springboot!"+ UUID.randomUUID();
    }


    @PostMapping("/helloUser")
    public String helloId(@RequestBody User user){
        System.out.println("into ...");
        return "Hello Springboot!"+ user.getName();
    }


    @GetMapping("/hello")
    public String hello(HttpSession session) {
        try {
            return "+++Hello Springboot!+++: "+session.getId()+"---"+session.isNew();
        }finally {
            session.invalidate();
        }

    }


    @PostMapping("/hello")
//    public String helloPost(@RequestBody(required = false) User user){
    public String helloPost(){
        System.out.println("into ..  .hello");
        System.out.println("into ...hello");
        System.out.println("into ...hello");
        System.out.println("into ...hello");
        System.out.println("into ...hello");
        System.out.println("into ...hello");
        System.out.println("into ...hello");
        System.out.println("into ...xmgxmgxmg");
        String hello = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<resources>\n" +
                "    <product name=\"QQ\">\n" +
                "        <account id=\"123456789\">\n" +
                "            <nickname>qq-account-1</nickname>\n" +
                "            <password>qwe123qwe123</password>\n" +
                "            <level>56</level>\n" +
                "        </account>\n" +
                "        <account id=\"987654321\">\n" +
                "            <nickname>qq-account-2</nickname>\n" +
                "            <password>ios9ios9ios9</password>\n" +
                "            <level>12</level>\n" +
                "        </account>\n" +
                "    </product>\n" +
                "    <product name=\"Netease\">\n" +
                "        <account id=\"tom\">\n" +
                "            <password>pwdOfTom</password>\n" +
                "            <capacity>1024</capacity>\n" +
                "        </account>\n" +
                "        <account name=\"Jim\">\n" +
                "            <password>pwdOfJim</password>\n" +
                "            <capacity>2560</capacity>\n" +
                "        </account>\n" +
                "    </product>\n" +
                "</resources>\n";
        return getString();
    }


    private String getString() {
        String str = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "   <soap:Body>\n" +
                "      <getSupportCityResponse xmlns=\"http://WebXml.com.cn/\">\n" +
                "         <getSupportCityResult>\n" +
                "            <string>北京 (54511)</string>\n" +
                "            <string>上海 (58367)</string>\n" +
                "            <string>天津 (54517)</string>\n" +
                "            <string>重庆 (57516)</string>\n" +
                "         </getSupportCityResult>\n" +
                "      </getSupportCityResponse>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>\n"
               ;
        return str;
    }



}
