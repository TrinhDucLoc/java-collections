package Streams;

import java.util.ArrayList;
import java.util.List;

public class App3 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        // finding 2 longest books (with more than 500 pages)
        // short-circuiting and loop fusion
        // filter() and map() are different operations, they
        // are merged into the same pass (loop fusion)
        // short-circuiting: some operations don’t need to process the whole
        // stream to produce a result
        // here we are looking for just 2 items - so the algorithm
        // terminates after finding 2 items !!!
        List<Book> bookList = books.stream()
                .filter(b -> b.getPages() > 500)
                .limit(2)
                .toList();

        bookList.forEach(System.out::println);

        List<String> titleList = books.stream()
                .filter(b -> b.getPages() > 500)
                .limit(2)
                .map(Book::getTitle)
                .toList();

        titleList.forEach(System.out::println);
    }
}
