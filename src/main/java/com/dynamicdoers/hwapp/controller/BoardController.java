package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Board;
import com.dynamicdoers.hwapp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public Board getBoard(){
        return boardService.getBoard();
    }


}
