package common.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream2 {
    static List<Employee> employees = new ArrayList();

    static {
        employees.add(new Employee("zhangsan", 24, 8888.0f));
        employees.add(new Employee("lisi", 23, 7688.0f));
        employees.add(new Employee("wanger", 32, 643.0f));
        employees.add(new Employee("mazi", 12, 100.0f));
        employees.add(new Employee("zhaosi", 44, 458.0f));
        employees.add(new Employee("zhaosi", 44, 1233.0f));
    }

    @Test
    public void test1() {
        Stream<Employee> s1 = employees.stream().filter((employee -> employee.salary > 600.0f));
        s1.limit(2).forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        //map的作用是把 Stream 映射到另外一个 Stream中
        Stream<Stream<Character>> s11 = list.stream().map(TestStream2::filterChar);
        s11.forEach(s1 -> {
            s1.forEach((ch -> {
                System.out.print(ch + ",");
            }));
        });

        //flatMap的作用是把 Stream 中的数据映射到另外一个 Stream中
        Stream<Character> s1 = list.stream().flatMap(TestStream2::filterChar);
        s1.forEach(ch -> {
            System.out.print(ch + ",");
        });
    }

    public static Stream<Character> filterChar(String str) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return list.stream();
    }
}
