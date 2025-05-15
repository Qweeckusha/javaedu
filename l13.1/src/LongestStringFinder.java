import java.io.*;
import java.util.Objects;

public class LongestStringFinder {

    public static void main(String[] args) {
        // Путь к файлу
        String filePath = "input.txt";

        // Лямбда-выражение для сравнения строк
        StringComparator longerString = (s1, s2) -> {
            if (s1 == null) return s2;
            if (s2 == null) return s1;
            return s1.length() >= s2.length() ? s1 : s2;
        };

        // Поиск самой длинной строки в файле
        String longestLine = findLongestLineInFile(filePath, longerString);

        // Вывод результата
        System.out.println("Самая длинная строка в файле:");
        System.out.println(longestLine);
    }

    // Метод для поиска самой длинной строки в файле
    private static String findLongestLineInFile(String filePath, StringComparator comparator) {
        String longestLine = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                longestLine = comparator.compare(longestLine, line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return longestLine;
    }
}

// Функциональный интерфейс
@FunctionalInterface
interface StringComparator {
    String compare(String s1, String s2);
}