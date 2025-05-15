import java.io.*;
import java.util.List;

public class ForeignAuthorReader {
    public static void main(String[] args) {
        // Путь к файлу с авторами
        String authorsFilePath = "Authors.txt";

        try {
            // Чтение авторов из файла через десериализацию
            List<Author> authors = readAuthorsFromFile(authorsFilePath);

            // Вывод зарубежных авторов
            System.out.println("Зарубежные авторы:");
            for (Author author : authors) {
                if (isForeignAuthor(author)) {
                    System.out.println(author);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для чтения авторов из файла через десериализацию
    private static List<Author> readAuthorsFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Author>) ois.readObject();
        }
    }

    // Метод для проверки, является ли автор зарубежным
    private static boolean isForeignAuthor(Author author) {
        // Зарубежные авторы имеют латинские символы в фамилии
        return author.getLastName().matches("[A-Z][a-z]+");
    }
}