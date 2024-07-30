package com.application.ProductivityHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        // Redireciona todas as requisições para a página principal do Angular
        return "forward:/index.html";
    }
}