package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App4 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        List<String> words = Arrays.asList("Adam", "Ana", "Daniel");
        List<Integer> length = words.stream()
                .map(String::length)
                .toList();

        length.stream().forEach(System.out::println);
        System.out.println();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream()
                .map(num -> num * num)
                .toList().forEach(System.out::println);

        String[] str = {"hello", "shell"};
        List<String> unique = Arrays.stream(str)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();

        unique.stream().forEach(System.out::println);
    }
}
