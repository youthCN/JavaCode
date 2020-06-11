package Generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


class Person<T1, T2> {

}

class Student extends Person<Integer, Boolean> {

    public static void test() {
        Student student = new Student();
        Class clazz = student.getClass();//getSuperclass()获得该类的父类
        System.out.println(clazz.getSuperclass());

        /**
         * getGenericSuperclass()获得带有泛型的父类
         * Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
         */
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);

        //ParameterizedType参数化类型，即泛型
        ParameterizedType p = (ParameterizedType) type;
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Class c1 = (Class) p.getActualTypeArguments()[0];
        System.out.println(c1);
        Class c2 = (Class) p.getActualTypeArguments()[1];
        System.out.println(c2);
    }
}

public class TestGeneric {
    public static void main(String[] args) {
        Student.test();
    }

    public static <T> void addAll1(List<T> list, List<? extends T> list2) {
        list.addAll(list2);
    }

    public static <T> void addAll2(List<T> list, List<? super T> list2) {
        list2.addAll(list);
    }
}
