package com.dynamicdoers.hwapp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping(path = "/error")
    public String getErrorHtml(Model model) {
        // model.addAttribute("message", studentService.getStudent(1).name);
        return "error";
    }
}

