package com.duanwu.webservice.service;

import com.duanwu.webservice.entity.User;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "HelloService",
        targetNamespace = "http://service.webservice.duanwu.com")
public interface HelloService {

    @WebResult(name = "helloContent")
    String hello(@WebParam(name = "helloMessage") String message);

    String helloWorld();

    String getusers();
}
