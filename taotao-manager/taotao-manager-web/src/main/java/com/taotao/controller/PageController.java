package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by syi on 2017-06-27.
 */
@Controller
public class PageController {

    //显示页面  直接跳转
    @RequestMapping("/{page}")
    public String showIndex(@PathVariable String page){
        return page;
    }

}
