package com.glmall.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("glmall-product")
@Component
public interface ProductFeignService {

    @RequestMapping("/bike/detail")
    public Object detail();
}
