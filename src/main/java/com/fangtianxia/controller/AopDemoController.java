package com.fangtianxia.controller;

import com.fangtianxia.annotation.AuthorityAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyz
 * 编写使用注解的被拦截类
 */
@RestController
@RequestMapping("aop")
public class AopDemoController {

    @RequestMapping("add")
    @AuthorityAnnotation(name = "ROLE_SUPER")
    public void add(){
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
    }
}
