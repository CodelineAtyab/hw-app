package com.dynamicdoers.hwapp.service;

import com.dynamicdoers.hwapp.model.Bot;
import org.springframework.stereotype.Component;

@Component
public class BotService {
    public Bot b;

    BotService(){
        this.b = new Bot();
    }
}
