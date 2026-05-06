package functionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;

class b implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer a) {
        return a + 1;
    }

    public void helloer() {

    }
}

public class Main {
    public static void main(String[] args) {
//        A a = new A() {
//                public void func() {
//                  System.out.println("hello world !!");
//                }
//        };
//
//        A b = () -> System.out.println("hey u r using lambda expression !!");
//
//        B c = new B() {
//            public void add(int a, int b) {
//                System.out.println(a + b);
//            }
//
//            public void print(ArrayList<Integer> a) {
//                a.forEach(num -> System.out.println(num));
//            }
//        };
//
//        a.func();
//        b.func();

//        Function<Integer, Integer> f1 = new b();
//        Function<Integer, Integer> f2 = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer a) {
//                return a + 1;
//            }
//        };
//        Function<Integer, Integer> f3 = a -> a + 1;
//
//        System.out.println(f1.apply(1));
//        System.out.println(f2.apply(1));
//        System.out.println(f3.apply(1));

        final Consumer<Integer> a = (Integer b) -> b = b + 1;
        Integer c = 0;
        a.accept(c);
        System.out.println(c);
    }
}