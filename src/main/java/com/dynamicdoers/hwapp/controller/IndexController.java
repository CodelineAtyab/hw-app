package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.service.StudentVolatileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    StudentVolatileService studentService;

    @GetMapping(path = "/index")
    public String index(Model model) {
        model.addAttribute("message", studentService.getStudent(1).name);
        return "index";
    }
}

