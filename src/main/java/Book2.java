import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Book2 {
    private static int id_counter = 0;
    private final int id;
    private String name;
    private String author;
    private Euro price;
    private int quantity;
    private Set<Language> languages;

    public Book2(String name, String author, Euro price, int quantity, Set<Language> list) {
        this.id = id_counter++;
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.languages = list;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", languages=" + languages;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Euro getPrice() {
        return price;
    }

    public void setPrice(Euro price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

}
