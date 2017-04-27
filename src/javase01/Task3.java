package javase01;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        List<Double> values = valuesToFunction(a, b);
        for (Double value : values) {
            System.out.println(a + " " + value);
            a++;
        }
    }

    private static List<Double> valuesToFunction(int a, int b) {
        return IntStream.rangeClosed(a, b).mapToDouble(i -> Math.tan(2 * i) - 3).boxed()
                .collect(Collectors.toList());
    }
}
