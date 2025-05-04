package functionalInterfaces;

import functionalInterfaces.A;
import functionalInterfaces.B;

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
            public void add(int a, int b) {
                System.out.println(a + b);
            }

            public void print(ArrayList<Integer> a) {
                a.forEach(num -> System.out.println(num));
            }
        };

        a.func();
        b.func();
    }
}