package com.duanwu.ankang.controller;


import com.duanwu.ankang.mode.Check;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@ResponseBody
@RestController
@Validated
@Slf4j
public class CheckController {

    @GetMapping("/check")
    public String check(@RequestBody@Validated Check check){
        return "check success!";
    }



    @PostMapping("/valid/test1")
    public String test1(@Validated @RequestBody Check validVO){
        log.info("validEntity is {}", validVO);
        return "test1 valid success";    }


    @PostMapping(value = "/valid/test2")
    public String test2(@Validated Check validVO){
        log.info("validEntity is {}", validVO);
        return "test2 valid success";    }


    @PostMapping(value = "/valid/test3")
    public String test3(@Email String email){
        log.info("email is {}", email);
        return "email valid success";
    }


    /**
     * 调用test1方法，提示的是org.springframework.web.bind.MethodArgumentNotValidException异常
     * POST http://localhost:8080/valid/test1Content-Type: application/json{   "id": 1,  "level": "12",  "email": "47693899",  "appId": "ab1c"}
     * {   "status": 500,  "message": "Validation failed for argument [0] in public java.lang.String com.jianzh5.blog.valid.ValidController.test1(com.jianzh5.blog.valid.ValidVO) with 3 errors: [Field error in object 'validVO' on field 'email': rejected value [47693899]; codes [Email.validVO.email,Email.email,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [validVO.email,email]; arguments []; default message [email],[Ljavax.validation.constraints.Pattern$Flag;@26139123,.*]; default message [不是一个合法的电子邮件地址]]...",  "data": null,  "timestamp": 1628239624332}
     * 调用test2方法，提示的是org.springframework.validation.BindException异常
     * POST http://localhost:8080/valid/test2Content-Type: application/x-www-form-urlencodedid=1&level=12&email=476938977&appId=ab1c
     * {   "status": 500,  "message": "org.springframework.validation.BeanPropertyBindingResult: 3 errors\nField error in object 'validVO' on field 'name': rejected value [null]; codes [NotBlank.validVO.name,NotBlank.name,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [validVO.name,name]; arguments []; default message [name]]; default message [名字为必填项]...",  "data": null,  "timestamp": 1628239301951}
     * 调用test3方法，提示的是javax.validation.ConstraintViolationException异常
     * POST http://localhost:8080/valid/test3Content-Type: application/x-www-form-urlencodedemail=476938977
     * {   "status": 500,  "message": "test3.email: 不是一个合法的电子邮件地址",  "data":
     */
}
