package com.dynamicdoers.hwapp.model;

import java.util.ArrayList;

public class NewBot {
    public static Board makeMove(Board inputBoard, Character Symbol){
        Board result = new Board();
        ArrayList<Character> row1 = new ArrayList<>();
        row1.add('O');
        row1.add('O');
        row1.add('O');

        result.grid.add(row1);
        result.grid.add(row1);
        result.grid.add(row1);

        return result;
    }
}
