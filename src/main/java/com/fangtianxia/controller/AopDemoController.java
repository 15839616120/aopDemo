package com.fangtianxia.controller;

import com.fangtianxia.annotation.AuthorityAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyz
 */
@RestController
@RequestMapping("aop")
public class AopDemoController {

    @RequestMapping("add")
    @AuthorityAnnotation(name = "ROLE_SUPER")
    public void add(){

    }
}
