package com.capstoneproject.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class will be serving the purpose of REST (HTTP) APIS >> @RestController
//This class will hava multiple methods
//That will be serving HTTP requests at /hello >> @RequestMapping("/hello")
//@RequestMapping("/hello") is saying that HelloController will be serving different methods
//at location /hello endpoint
//localhost:8080/hello  server:port/endpoint
@RestController
@RequestMapping("/hello")
public class HelloController{
//    So basically if someone will call /hello, this class will be invoked
//    furthermore we can create multiple methods and define their endpoints post /hello

    @GetMapping("/say")
    public String sayHello(){
//        effective endpoint for this method is /hello/say
        return "Hello There";
    }

    @GetMapping("/callFunction2")
    public String function2(){
//        effective endpoint for this method is /hello/callFunction2
        return "Hello There from function2";
    }

    @GetMapping("/")
    public String doNothing(){
//        effective endpoint for this method is /hello/
        return "I will do nothing";
    }

    @GetMapping("/sayMyName/{name}/{times}")
    public String doNothing(@PathVariable("name") String name,
                            @PathVariable("times") int times){
//        effective endpoint for this method is /hello/sayMyName/{name}
//        {name} becomes a variable because of curly braces
//        We can have multiple variables
        String names = "";
        for(int i=0;i<times;i++){
            names = names + "I am...";
            names += "<br>";
        }
        return names+name;
    }
}
//Now Run the project and then go to browser and hit the urls
//localhost:8080/hello/
//localhost:8080/hello/say
//localhost:8080/hello/callFunction2
//localhost:8080/hello/sayMyName/
// .....
//Read Below before next class
//https://docs.spring.io/spring-framework/reference/core/beans/introduction.html
//https://docs.spring.io/spring-framework/reference/overview.html
//https://spring.io/guides/gs/rest-service/