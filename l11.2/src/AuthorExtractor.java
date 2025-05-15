import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class AuthorExtractor {
    public static void main(String[] args) {
        // Путь к исходному файлу
        String filePath = "src/file.txt";
        // Путь к файлу для сохранения авторов
        String authorsFilePath = "Authors.txt";

        try {
            // Чтение файла и поиск авторов
            List<Author> authors = extractAuthors(filePath);

            // Сохранение авторов в файл через сериализацию
            saveAuthorsToFile(authors, authorsFilePath);

            System.out.println("Авторы успешно сохранены в файл: " + authorsFilePath);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    // Метод для извлечения авторов из файла
    private static List<Author> extractAuthors(String filePath) throws IOException {
        List<Author> authors = new ArrayList<>();
        Pattern pattern = Pattern.compile("([А-ЯA-Z][а-яa-z]+\\s+[А-ЯA-Z]\\.[А-ЯA-Z]?\\.?)");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String authorString = matcher.group();
                    String[] parts = authorString.split("\\s+");
                    String lastName = parts[0];
                    String initials = parts[1];
                    authors.add(new Author(lastName, initials));
                }
            }
        }

        return authors;
    }

    // Метод для сохранения авторов в файл через сериализацию
    private static void saveAuthorsToFile(List<Author> authors, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(authors);
        }
    }
}