import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Book2> bookList = (List.of(
                new Book2("Harry Potter 1", "J. K. Rowling", new Euro(1300), 4,
                         new HashSet<>(Set.of(Language.ENGLISH, Language.GERMAN)))
        ));

        System.out.println(bookList.toString());

        bookList.get(0).getLanguages();


        System.out.println(bookList);
    }
}
