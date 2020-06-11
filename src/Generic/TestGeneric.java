package Generic;

import java.util.List;

public class TestGeneric {
    public static void main(String[] args) {

    }

    public static <T> void addAll1(List<T> list, List<? extends T> list2) {
        list.addAll(list2);
    }

    public static <T> void addAll2(List<T> list, List<? super T> list2) {
        list2.addAll(list);
    }
}
