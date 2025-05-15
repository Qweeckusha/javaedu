public class Main {
    public static void main(String[] args) {
        IntegerContainer container = new IntegerContainer();

        try {
            System.out.println("Добавление элементов:");
            container.push(2);
            container.push(6);
            container.push(9);
            container.push(2);
            System.out.println(container);

            System.out.println("Удален элемент: " + container.pop());
            System.out.println(container);

            System.out.println("Сортировка элементов...");
            container.sort();
            System.out.println("После сортировки: " + container);

            int index = container.search(6);
            System.out.println("Индекс элемента 6: " + index);

            // Проверка метода поиска дубликата Вар 2
            System.out.println("Добавление дубликата элемента 6...");
            container.push(6); // Специально добавляем дубликат
            container.search(6); // Генерирует исключение
        } catch (CustomExceptions.ContainerFullException | CustomExceptions.ContainerEmptyException |
                 CustomExceptions.SortException | CustomExceptions.SearchException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}