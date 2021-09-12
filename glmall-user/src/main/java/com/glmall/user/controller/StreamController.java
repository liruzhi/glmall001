package com.glmall.user.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamController {
    public static void main(String[] args) {
        getThreeHighCaloricDishNames();
        twoNumbersStream();
    }

    public static  void getThreeHighCaloricDishNames(){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d->d.getCalories() >300)
                        .sorted(Comparator.comparing(Dish::getCalories).reversed())
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);
    }

    //返回两个元素之和能被3整除的
    public static void twoNumbersStream() {
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        List<int[]> pairs =
                numbers1.stream()
                .flatMap(i->numbers2.stream().
                        filter(j->(i + j) % 3 == 0)
                        .map(j->new int[]{i,j})
                )
                .collect(Collectors.toList());

        System.out.println(pairs);
    }



}
