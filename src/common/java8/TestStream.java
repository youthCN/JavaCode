package common.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        //创建流的第一种方式,使用集合创建流
        List<String> list1 = new ArrayList<>();
        Stream<String> stream1 = list1.stream();
        //使用数组创建流
        Integer[] ints = new Integer[10];
        Stream<Integer> stream2 = Arrays.stream(ints);

        //使用Stream的静态方法of创建
        Stream<Character> stream3 = Stream.of('a', 'b', 'c');
//        Stream<Integer> stream3 = Stream.of(ints);

        //创建一个无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10)
                .forEach(System.out::println);
        Stream.generate(()->Math.random())
                .limit(5).forEach(System.out::println);

    }
}
