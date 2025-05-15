public class Product {
    private static int idCounter = 1;
    private final String name;
    private final int id;

    public Product(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " #" + id;
    }
}