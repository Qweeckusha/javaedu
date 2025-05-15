import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Тест с числами
        ArrayList<Comparable> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);
        System.out.println("Исходный список чисел: " + numbers);
        System.out.println("Максимальное и минимальное значения: " + MaxAndMinFinder.maxAndMin(numbers));

        // Тест со строками
        ArrayList<Comparable> strings = new ArrayList<>();
        strings.add("Apple");
        strings.add("банан");
        strings.add("апельсин");
        strings.add("мандарин");
        System.out.println("\nИсходный список строк: " + strings);
        System.out.println("Максимальное и минимальное значения: " + MaxAndMinFinder.maxAndMin(strings));

        // Тест с объектами собственного класса
        ArrayList<Comparable> people = new ArrayList<>();
        people.add(new MaxAndMinFinder.Person("Алиса", 90));
        people.add(new MaxAndMinFinder.Person("Валера", 25));
        people.add(new MaxAndMinFinder.Person("Александр", 35));
        System.out.println("\nИсходный список людей: " + people);
        System.out.println("Максимальное и минимальное значения: " + MaxAndMinFinder.maxAndMin(people));
    }
}