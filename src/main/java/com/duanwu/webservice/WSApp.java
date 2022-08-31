package com.duanwu.webservice;

import com.duanwu.webservice.service.imp.HelloServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.xml.ws.Endpoint;


@SpringBootApplication
public class WSApp {

    public static void main(String[] args) {

        SpringApplication.run(WSApp.class, args);

    }


}
