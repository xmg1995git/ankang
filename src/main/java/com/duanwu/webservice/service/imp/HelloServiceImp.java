package com.duanwu.webservice.service.imp;

import com.duanwu.webservice.entity.User;
import com.duanwu.webservice.service.HelloService;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.naming.Name;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebService(serviceName = "HelloService", // 与接口中指定的服务name一致
        targetNamespace = "http://service.webservice.duanwu.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.duanwu.webservice.service.HelloService"// 接口地址
)
@Service
public class HelloServiceImp implements HelloService {

    private static List<User> userList = new ArrayList<>();
    static {
        User user1 = new User("a", "小A", 11, new Date());
        User user2 = new User("b", "小B", 22, new Date());
        User user3 = new User("c", "小C", 33, new Date());
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }


    @Override
    public String hello(String message) {
        return "收到: "+message;
    }

    @Override
    public String helloWorld() {
        return "hello world!!!";
    }

    @WebMethod
    @Override
    public String getusers() {
        Element root = new Element("root");
        Document Doc = new Document(root);
        Element element=new Element("data");
        element.addContent(new Element("msg").setText(userList.toString()));
        root.addContent(element);
        XMLOutputter XMLOut = new XMLOutputter(Format.getPrettyFormat().setEncoding("UTF-8"));
        XMLOut.outputString(Doc);
        return  XMLOut.outputString(Doc);
//        return userList;
    }
}
