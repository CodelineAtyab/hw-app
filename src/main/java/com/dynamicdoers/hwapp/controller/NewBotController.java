package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Board;
import com.dynamicdoers.hwapp.model.NewBot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/newbot")
public class NewBotController {
    @PostMapping
    public Board getResult(@RequestBody Board inputBoard){
        return NewBot.makeMove(inputBoard, 'O');
    }
}
