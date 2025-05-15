import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Sentence implements Iterable<String> {
    private List<String> words;

    // Конструктор класса
    public Sentence() {
        this.words = new ArrayList<>();
        try {
            // Чтение текста из файла input.txt
            String text = readFile("input.txt");
            // Удаляем знаки препинания и разделяем строку на слова
            this.words = Arrays.stream(text.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "").split("\\s+"))
                    .filter(word -> !word.isEmpty()) // Убираем пустые строки
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для чтения содержимого файла
    private String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString().trim(); // Убираем лишние пробелы
    }

    // Реализация метода iterator() из интерфейса Iterable
    @Override
    public Iterator<String> iterator() {
        return new WordIterator();
    }

    // Внутренний класс для реализации итератора
    private class WordIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < words.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more words in the sentence.");
            }
            return words.get(currentIndex++);
        }
    }

    // Метод для тестирования
    public static void main(String[] args) {
        Sentence sentence = new Sentence();

        // Использование итератора через цикл for-each
        System.out.println("Слова в предложении:");
        for (String word : sentence) {
            System.out.println(word);
        }

        // Использование явного итератора
        System.out.println("\nИспользование явного итератора:");
        Iterator<String> iterator = sentence.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}