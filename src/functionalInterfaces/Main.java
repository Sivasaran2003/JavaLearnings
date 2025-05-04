package functionalInterfaces;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        A a = new A() {
                public void func() {
                  System.out.println("hello world !!");
                }
        };

        A b = () -> System.out.println("hey u r using lambda expression !!");

        B c = new B() {
            @Override
            public void add(int a, int b) {
                System.out.println(a + b);
            }
        };

        a.func();
        b.func();
    }
}