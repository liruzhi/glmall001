package com.glmall.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("bike")
public class BikeController {

    @RequestMapping("/detail")
    public Object detail() {
        HashMap<String,String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        return map;
    }
}
