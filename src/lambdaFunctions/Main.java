package lambdaFunctions;


import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> method = (name) -> System.out.println("hello " + name);
        method.accept("Siva");
    }
}
