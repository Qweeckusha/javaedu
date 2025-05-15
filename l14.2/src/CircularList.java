import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularList<T extends Comparable<T>> implements Iterable<T> {
    private ArrayList<T> data;

    public CircularList() {
        this.data = new ArrayList<>();
    }

    // Метод для добавления элементов
    public void add(T element) {
        data.add(element);
    }

    // Реализация метода iterator() из интерфейса Iterable
    @Override
    public Iterator<T> iterator() {
        return new CircularIterator();
    }

    // Внутренний класс для реализации итератора
    private class CircularIterator implements Iterator<T> {
        private int currentIndex = 0;
        private boolean firstIteration = true;

        @Override
        public boolean hasNext() {
            // Итератор всегда имеет следующий элемент (кольцевой)
            return !data.isEmpty();
        }

        @Override
        public T next() {
            if (data.isEmpty()) {
                throw new NoSuchElementException("Список пуст.");
            }

            // Получаем первый элемент для сравнения
            T firstElement = data.get(0);

            // Ищем следующий подходящий элемент
            T currentElement = null;
            do {
                currentElement = data.get(currentIndex);
                currentIndex = (currentIndex + 1) % data.size(); // Кольцевая навигация
                if (firstIteration) {
                    firstIteration = false; // Первый элемент всегда возвращается
                    return currentElement;
                }
            } while (currentElement.compareTo(firstElement) < 0); // Игнорируем элементы меньше первого

            return currentElement;
        }
    }
}