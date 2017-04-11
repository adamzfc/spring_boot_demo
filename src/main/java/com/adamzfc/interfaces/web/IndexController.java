package com.adamzfc.interfaces.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by adamzfc on 4/7/17.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }

}
