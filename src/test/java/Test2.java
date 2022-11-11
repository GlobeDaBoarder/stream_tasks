import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Test2 {
    private List<Book2> bookList;
    private List<Book2> resultList;

    @BeforeEach
    void init(){
        this.bookList = List.of(
                new Book2("Harry Potter 1", "J. K. Rowling", new Euro(1300), 4,
                        new HashSet<>(Set.of(Language.ENGLISH, Language.GERMAN, Language.SPANISH, Language.RUSSIAN))),
                new Book2("Harry Potter 2", "J. K. Rowling", new Euro(1400), 12,
                        new HashSet<>(Set.of(Language.GERMAN))),
                new Book2("Harry Potter 3", "J. K. Rowling", new Euro(1500), 8,
                        new HashSet<>(Set.of(Language.SPANISH))),
                new Book2("Harry Potter 4", "J. K. Rowling", new Euro(1600), 1,
                        new HashSet<>(Set.of(Language.RUSSIAN))),
                new Book2("Art of war", "Sun Tzu", new Euro(900), 16,
                        new HashSet<>(Set.of(Language.ENGLISH))),
                new Book2("Dream of the Red Cha", "Cao Xueq", new Euro(700), 7,
                        new HashSet<>(Set.of(Language.ENGLISH, Language.GERMAN, Language.SPANISH, Language.RUSSIAN))),
                new Book2("The Alchemist", "Paulo Coelho", new Euro(999), 11,
                        new HashSet<>(Set.of(Language.ENGLISH, Language.GERMAN))),
                new Book2("The Little Prince", "Antoine de Saint-Exu", new Euro(1199), 26,
                        new HashSet<>(Set.of(Language.GERMAN, Language.RUSSIAN))),
                new Book2("Art of war", "Sun Tzu", new Euro(2100), 9,
                        new HashSet<>(Set.of(Language.SPANISH, Language.RUSSIAN)))
        );

        this.resultList = new ArrayList<>();
    }

    @Test
    void testOutputOfList(){
        assertEquals("""
                        [id =0, name = Harry Potter 1, author = J. K. Rowling, price = 13.00, quantity= 4
                        , id =1, name = Harry Potter 2, author = J. K. Rowling, price = 14.00, quantity= 12
                        , id =2, name = Harry Potter 3, author = J. K. Rowling, price = 15.00, quantity= 8
                        , id =3, name = Harry Potter 4, author = J. K. Rowling, price = 16.00, quantity= 1
                        , id =4, name = Art of war, author = Sun Tzu, price = 9.00, quantity= 16
                        , id =5, name = Dream of the Red Cha, author = Cao Xueq, price = 7.00, quantity= 7
                        , id =6, name = The Alchemist, author = Paulo Coelho, price = 9.99, quantity= 11
                        , id =7, name = The Little Prince, author = Antoine de Saint-Exu, price = 11.99, quantity= 26
                        , id =8, name = Art of war, author = Sun Tzu, price = 21.00, quantity= 9
                        ]""",
                this.bookList.toString());
    }

    @Test
    void test3() {
        //replace every instance of russian with chinese

        this.bookList.forEach(System.out::println);
        this.resultList = this.bookList
                .stream()
                .peek(
                        book -> book.setLanguages(
                                book.getLanguages()
                                        .stream()
                                        .map(language -> {
                                            if(language == Language.RUSSIAN)
                                                language = Language.CHINESE;
                                            return language;
                                        })
                                        .collect(Collectors.toSet())
                        )

                )
                .collect(Collectors.toList());

        System.out.println("-------------------------------------------");
        this.resultList.forEach(System.out::println);
    }

    @Test
    void test4() {
        //replace every instance of russian with chinese

        this.bookList.forEach(System.out::println);

        this.resultList = this.bookList
                .stream()
                .peek(
                        book -> book.setLanguages(
                                book.getLanguages()
                                        .stream()
                                        .map(language -> {
                                            if(language == Language.RUSSIAN)
                                                language = Language.CHINESE;
                                            return language;
                                        })
                                        .collect(Collectors.toSet())
                        )

                )
                .collect(Collectors.toList());

        System.out.println("-------------------------------------------");
        this.resultList.forEach(System.out::println);
    }

}
