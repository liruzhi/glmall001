package com.glmall.user.controller;

import com.glmall.user.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RefreshScope
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    ProductFeignService productFeignService;

    @Value("${glmall.user.name}")
    private String name;

    @Value("${glmall.user.age}")
    private Integer age;

    @RequestMapping("/bike_detail")
    public Object getBikeDetail() {

        Object res = productFeignService.detail();
        HashMap<String,Object> map = new HashMap<>();
        map.put("feign_product", res);
        map.put("user", "user001");
        return map;
    }

    @RequestMapping("/config")
    public Object getConfig() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);

        return map;
    }
}
