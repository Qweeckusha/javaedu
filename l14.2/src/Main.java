public class Main {
    public static void main(String[] args) {
        // Тестирование на строках
        CircularList<String> stringList = new CircularList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("date");
        stringList.add("fig");

        System.out.println("Итерация по строкам:");
        int iterations = 0;
        for (String item : stringList) {
            System.out.println(item);
            iterations++;
            if (iterations >= 10) { // Ограничиваем количество итераций, оно необходимо потому что итератор уходит в кольцевой цикл
                break;
            }
        }

        // Тестирование на объектах Person
        CircularList<Person> personList = new CircularList<>();
        personList.add(new Person("Alice", 30));
        personList.add(new Person("Bob", 25));
        personList.add(new Person("Charlie", 35));
        personList.add(new Person("David", 20));

        System.out.println("\nИтерация по объектам Person:");
        int iterations2 = 0;
        for (Person person : personList) {
            System.out.println(person);
            iterations2++;
            if (iterations2 >= 10) { // Ограничиваем количество итераций, оно необходимо потому что итератор уходит в кольцевой цикл
                break;
            }
        }
    }
}