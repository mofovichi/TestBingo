package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BingoStartController {

    @RequestMapping("/")
    public String index(){
        return "start";
    }
}
