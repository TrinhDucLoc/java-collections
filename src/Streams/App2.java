package Streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        // external iteration (collections)
        List<String> title1 = new ArrayList<>();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            title1.add(iterator.next().getTitle());
        }

        System.out.println("TITLE 1: ");
        title1.forEach(System.out::println);

        List<String> title2 = books.stream()
                .map(Book::getTitle)
                .toList();

        System.out.println();
        System.out.println("TITLE 2: ");
        title2.forEach(System.out::println);

    }


}
