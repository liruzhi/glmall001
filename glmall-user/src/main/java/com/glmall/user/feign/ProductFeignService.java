package com.glmall.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "glmall-product")
public interface ProductFeignService {

    @RequestMapping("/bike/detail")
    public Object detail();
}
