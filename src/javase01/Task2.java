package javase01;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//WARNING! This code needs JDK 9 as it uses takeWhile(DoublePredicate predicate) function

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double epsilon = sc.nextDouble();
        sc.close();
        final List<Double> sequence = getSequence(epsilon);
        System.out.println(sequence.size());
        System.out.println(sequence.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static List<Double> getSequence(double epsilon) {
        return IntStream.iterate(1, i -> i + 1).mapToDouble(n -> 1.0 / Math.pow(n + 1, 2))
                .takeWhile(p -> p >= epsilon).boxed().collect(Collectors.toList());
    }
}
