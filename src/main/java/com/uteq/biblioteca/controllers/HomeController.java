package com.uteq.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "home", "index"})
    public String index(){
        return "index_JPCM";
    }

    @GetMapping("login")
    public String login(){
        return "views/login_JPCM";
    }


}
