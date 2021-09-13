package com.glmall.user.controller;

import com.glmall.user.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

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

    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));

//        List<String> listOfStrings = new ArrayList<>();
//        listOfStrings.add("a");
//        listOfStrings.add("");
//        listOfStrings.add("c");
//        listOfStrings.add("d");
//        System.out.println(listOfStrings);
//        List<String> nonEmpty = filter(listOfStrings, (String s) -> !s.isEmpty() && !"a".equals(s));
        List<String> nonEmpty = filter(Arrays.asList("a","","c"), (String s) -> !s.isEmpty() && !"a".equals(s));
        System.out.println("=============");
        System.out.println(nonEmpty);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s: list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public static  <T> void forEach(List<T> list, Consumer<T> c) {
        for(T i: list) {
            c.accept(i);
        }
    }


}
