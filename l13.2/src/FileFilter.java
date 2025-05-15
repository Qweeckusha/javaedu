import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileFilter {

    public static void main(String[] args) {
        // Путь к входному и выходному файлам
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Лямбда-выражение для проверки делимости на 13
        NumberPredicate isDivisibleBy13 = (number) -> number % 13 == 0;

        try {
            // Чтение чисел из входного файла
            List<Integer> numbers = readNumbersFromFile(inputFilePath);

            // Фильтрация чисел
            List<Integer> filteredNumbers = new ArrayList<>();
            for (int number : numbers) {
                if (!isDivisibleBy13.test(number)) {
                    filteredNumbers.add(number);
                }
            }

            // Запись отфильтрованных чисел в выходной файл
            writeNumbersToFile(outputFilePath, filteredNumbers);

            System.out.println("Файл успешно обработан. Результат записан в " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }

    // Метод для чтения чисел из файла
    private static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Некорректное число в файле: " + line);
                }
            }
        }
        return numbers;
    }

    // Метод для записи чисел в файл
    private static void writeNumbersToFile(String filePath, List<Integer> numbers) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int number : numbers) {
                writer.write(String.valueOf(number));
                writer.newLine();
            }
        }
    }
}

// Функциональный интерфейс
@FunctionalInterface
interface NumberPredicate {
    boolean test(int number);
}