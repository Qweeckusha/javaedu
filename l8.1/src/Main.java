public class Main {
    public static void main(String[] args) {
        IntegerContainer container = new IntegerContainer();

        try {
            // Добавляем элементы
            container.push(5);
            container.push(3);
            container.push(8);
            container.push(3); // Дубликат
            System.out.println(container);

            // Удаляем элемент
            System.out.println("Удален элемент: " + container.pop());
            System.out.println(container);

            // Сортируем элементы
            container.sort();
            System.out.println("После сортировки: " + container);

            // Поиск элемента 8
            int index = container.search(8);
            System.out.println("Индекс элемента 8: " + index);

            // Проверка метода поиска дубликата
            container.push(8); // Специально добавляем дубликат
            container.search(8); // Генерирует исключение
        } catch (ContainerFullException | ContainerEmptyException | SortException | SearchException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}