package ArraySort;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 7, 8, 3};
        String[] names = {"Kevin", "Daniel", "Katy", "Ana", "Joe", "Adam"};

        Arrays.stream(names)
                .sorted()
                .toList().forEach(System.out::println);

        Arrays.stream(nums)
                .sorted()
                .forEach(System.out::println);
    }
}
