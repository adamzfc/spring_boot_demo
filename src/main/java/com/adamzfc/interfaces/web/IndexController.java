package com.adamzfc.interfaces.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by adamzfc on 4/7/17.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        throw new RuntimeException("msg");
//        return "index";
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }

}
