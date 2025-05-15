import java.util.ArrayList;
import java.util.Collections;

public class MaxAndMinFinder {

    // Метод для поиска максимального и минимального значений
    public static ArrayList<Comparable> maxAndMin(ArrayList<Comparable> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("Список должен содержать как минимум два элемента.");
        }

        // Находим максимальное и минимальное значение
        Comparable max = Collections.max(list);
        Comparable min = Collections.min(list);

        // Создаем новый список с элементами в порядке убывания
        ArrayList<Comparable> result = new ArrayList<>();
        result.add(max);
        result.add(min);

        return result;
    }

    // Собственный класс, реализующий интерфейс Comparable
    public static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age); // Сравнение по возрасту
        }

        @Override
        public String toString() {
            return name + " - " + age + " лет";
        }
    }
}