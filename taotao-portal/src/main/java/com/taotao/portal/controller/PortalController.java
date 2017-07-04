package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by syi on 2017-07-04.
 */
@Controller
public class PortalController {
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
