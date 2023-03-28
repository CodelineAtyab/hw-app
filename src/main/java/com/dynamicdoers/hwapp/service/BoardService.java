package com.dynamicdoers.hwapp.service;

import com.dynamicdoers.hwapp.model.Board;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoardService {
    public Board board = new Board();

    public Board getBoard() {
        return board;
    }
}
