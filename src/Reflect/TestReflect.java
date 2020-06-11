package Reflect;

public class TestReflect {
    /**
     * isAssignableFrom()方法与instanceof关键字的区别总结为以下两个点：
     *      isAssignableFrom()方法是从类继承的角度去判断，instanceof关键字是从实例继承的角度去判断。
     *      isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。
     *
     * isInstance是Class类的一个方法isInstance(Object obj)，obj是被测试的对象，
     * 如果obj是调用这个方法的class或接口 的实例，则返回true。
     * 这个方法是instanceof运算符的动态等价
     *
     * @param args
     */
    public static void main(String[] args) {
        Class<String> strClass = String.class;
        String str = "hello";
        boolean instanceOf = str instanceof String;
        boolean isAssignableFrom = strClass.isAssignableFrom(String.class);
        System.out.println(instanceOf);
        System.out.println(isAssignableFrom);

        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println("a instanceof A --->" + (a instanceof A));
        System.out.println("b instanceof A --->" + (b instanceof A));
        System.out.println("a instanceof B --->" + (a instanceof B));
        System.out.println("b instanceof B --->" + (b instanceof B));
    }

    static class A {

    }

    static class B extends A {

    }

    static class C extends B {
    }
}
