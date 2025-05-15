public class Part {
    private static int idCounter = 1;
    private final String type;
    private final int id;

    public Part(String type) {
        this.type = type;
        this.id = idCounter++;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return type + " #" + id;
    }
}