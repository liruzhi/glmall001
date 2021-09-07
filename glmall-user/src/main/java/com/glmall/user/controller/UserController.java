package com.glmall.user.controller;

import com.glmall.user.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    ProductFeignService productFeignService;

    @RequestMapping("/bike_detail")
    public Object getBikeDetail() {

        Object res = productFeignService.detail();
        return res;
    }
}
