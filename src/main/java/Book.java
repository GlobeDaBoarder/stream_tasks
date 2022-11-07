public class Book {
    private static int id_counter = 0;
    private int id;
    private String name;
    private String author;
    private Euro price;
    private int quantity;

    public Book(String name, String author, Euro price, int quantity) {
        this.id = id_counter++;
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "id =" + id +
                ", name = " + name +
                ", author = " + author +
                ", price = " + price +
                ", quantity= " + quantity + "\n" ;
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
}
