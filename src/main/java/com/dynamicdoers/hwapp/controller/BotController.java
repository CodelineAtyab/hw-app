package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Board;
import com.dynamicdoers.hwapp.service.BoardService;
import com.dynamicdoers.hwapp.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/bot")
public class BotController {

    @Autowired
    private BotService botService;
    @Autowired
    private BoardService boardService;

    @PostMapping
    public Board getMove(@RequestBody Board inputState){
        return botService.b.makeMove(inputState, 'O');
    }
}
