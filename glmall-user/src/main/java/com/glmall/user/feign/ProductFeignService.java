package com.glmall.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("glmall-product")
public interface ProductFeignService {

    @RequestMapping("/bike/detail")
    public Object detail();
}
