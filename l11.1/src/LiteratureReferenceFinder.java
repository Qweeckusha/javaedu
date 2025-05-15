import java.io.*;
import java.util.regex.*;

public class LiteratureReferenceFinder {

    // Регулярное выражение для ссылки на литературу
    private static final String REFERENCE_REGEX =
            "\\d+\\.\\s+([А-ЯA-Z][а-яa-z]+\\s+[А-ЯA-Z]\\.[А-ЯA-Z]?\\.\\s*(,\\s*)?)+\\s*.*?\\s*\\d{4};\\s*\\d+\\([^)]+\\):\\s*\\d+([–-]\\d+)";

    // Функция проверяет, является ли строка ссылкой на литературу
    public static boolean isLiteratureReference(String line) {
        Pattern pattern = Pattern.compile(REFERENCE_REGEX);
        Matcher matcher = pattern.matcher(line.trim());
        return matcher.find(); // Ищем частичное соответствие
    }

    // Метод для чтения файла и поиска ссылок
    public static void findReferencesInFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "Windows-1251"))) {

            Pattern pattern = Pattern.compile(REFERENCE_REGEX);
            String line;
            System.out.println("Найденные литературные источники:");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("Найдена ссылка: " + line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}