import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionCreationTest {
    private List<Book> bookList;
    private List<Book> resultList;

    @BeforeEach
    void init(){
        this.bookList = List.of(
                new Book("Harry Potter 1", "J. K. Rowling", new Euro(1300), 4),
                new Book("Harry Potter 2", "J. K. Rowling", new Euro(1400), 12),
                new Book("Harry Potter 3", "J. K. Rowling", new Euro(1500), 8),
                new Book("Harry Potter 4", "J. K. Rowling", new Euro(1600), 1),
                new Book("Art of war", "Sun Tzu", new Euro(900), 16),
                new Book("Dream of the Red Cha", "Cao Xueq", new Euro(700), 7),
                new Book("The Alchemist", "Paulo Coelho", new Euro(999), 11),
                new Book("The Little Prince", "Antoine de Saint-Exu", new Euro(1199), 26),
                new Book("Art of war", "Sun Tzu", new Euro(2100), 9)
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
    void findBooksWithAuthorJKRowling(){
        // get books with author J. K. Rowling
        this.resultList = this.bookList
                .stream()
                .filter(book -> book.getAuthor().equals("J. K. Rowling"))
                .collect(Collectors.toList());

        assertEquals("""
                        [id =0, name = Harry Potter 1, author = J. K. Rowling, price = 13.00, quantity= 4
                        , id =1, name = Harry Potter 2, author = J. K. Rowling, price = 14.00, quantity= 12
                        , id =2, name = Harry Potter 3, author = J. K. Rowling, price = 15.00, quantity= 8
                        , id =3, name = Harry Potter 4, author = J. K. Rowling, price = 16.00, quantity= 1
                        ]"""
                , this.resultList.toString());
    }

    @Test
    void decreasePriceBy2ForBooksOver10Euros(){
        //decrease the Price By 2.00 euros For Books Over 10 Euros
        this. resultList = this.bookList
                .stream()
                .filter(book -> book.getPrice().compareTo(new Euro(1000)) > 0 )
                .map(book -> {
                    book.setPrice(book.getPrice().sub(new Euro(200)));
                    return book;
                })
                .collect(Collectors.toList());

        assertEquals("""
                        [id =0, name = Harry Potter 1, author = J. K. Rowling, price = 11.00, quantity= 4
                        , id =1, name = Harry Potter 2, author = J. K. Rowling, price = 12.00, quantity= 12
                        , id =2, name = Harry Potter 3, author = J. K. Rowling, price = 13.00, quantity= 8
                        , id =3, name = Harry Potter 4, author = J. K. Rowling, price = 14.00, quantity= 1
                        , id =7, name = The Little Prince, author = Antoine de Saint-Exu, price = 9.99, quantity= 26
                        , id =8, name = Art of war, author = Sun Tzu, price = 19.00, quantity= 9
                        ]""",
                this.resultList.toString());
    }

    @Test
    void findBiggestStockAmount(){
        //find name of book with the biggest quanitty

        String bookName = this.bookList
                .stream()
                .max(Comparator.comparing(Book::getQuantity))
                .get().getName();

        assertEquals("The Little Prince", bookName);
    }
}
