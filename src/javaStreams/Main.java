package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 4, 2));
        arr.stream()
                .filter(num -> num % 2 == 1)
                .map(num -> num * 2)
                .forEach(num -> System.out.println(num));

        int sum = arr.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num + 2)
                .reduce(1, (a, b) -> a + b);
        System.out.println(arr.stream().reduce(1, (a, b) -> a * b));
        System.out.println(sum);

        Stream<Integer> stream = arr.stream().map(num -> num % 2);
        stream.forEach(num -> System.out.print(String.valueOf(num == 1) + " "));

    }
}
