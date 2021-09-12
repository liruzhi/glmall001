package com.glmall.user.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaController {

    public static void main(String[] args) {
        System.out.println(filter(Arrays.asList("a", "b", "", "d"), (String s) -> !s.isEmpty()));

        forEach(Arrays.asList(1,2,3,4), (Integer i) -> System.out.println(i));

        System.out.println(map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length()));
        System.out.println(map(Arrays.asList("lambdas", "in", "action"), String::length));
        System.out.println(map(Arrays.asList(1, 2, 3), (Integer i) -> i+1));

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();

        for (T s:list) {
            if (p.test(s)) {
                results.add(s);
            }
        }

        return results;
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i:list) {
            c.accept(i);
        }
    }

    public interface Function<T,R> {
        R apply(T t);
    }

    public static <T,R> List<R> map(List<T> list,Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for (T s:list) {
            result.add(f.apply(s));
        }

        return result;
    }
}


