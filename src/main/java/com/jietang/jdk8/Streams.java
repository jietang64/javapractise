package com.jietang.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对collection进行流式处理
 *
 * @author: jietang
 * @create: 2021/5/25-10:45 上午
 **/

public class Streams {
    public static void main(String[] args) {
        Integer[] ints1 = {1, 3, 4, 6, 7, 2, 4};
        List<Integer> ints = Arrays.asList(ints1);
        List<Integer> collect = ints.stream().map(i -> i + 1).filter(i -> i > 5).sorted().collect(Collectors.toList());
        System.out.println(collect.toString());
    }
}
