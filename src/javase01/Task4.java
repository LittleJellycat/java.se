package javase01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input: sequence length first, then sequence numbers
        int sequenceLength = sc.nextInt();
        ArrayList<Integer> sequence = IntStream.range(0, sequenceLength)
                .mapToObj(i -> sc.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        sc.close();
        if (sequence.size() % 2 != 0) {
            sequence.add(0);
        }
        Integer max = Integer.MIN_VALUE;
        System.out.println(IntStream.range(0, sequence.size() / 2)
                .map(i -> sequence.get(2 * i) + sequence.get(2 * i + 1))
                .max().orElse(Integer.MIN_VALUE));
        System.out.println(max);
    }
}
