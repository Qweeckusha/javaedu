import java.util.ArrayList;

public class GenericStack<E> {
    private static final int INITIAL_CAPACITY = 5; // Начальный размер массива
    private E[] arr; // Массив для хранения элементов
    private int size; // Текущий размер стека

    // Конструктор
    @SuppressWarnings("unchecked")
    public GenericStack() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Метод для получения текущего размера стека
    public int getSize() {
        return size;
    }

    // Метод для просмотра верхнего элемента стека
    public E peek() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        return arr[size - 1];
    }

    // Метод для добавления элемента в стек
    @SuppressWarnings("unchecked")
    public void push(E element) {
        // Если массив заполнен, увеличиваем его размер
        if (size == arr.length) {
            E[] newArr = (E[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }

    // Метод для удаления и возврата верхнего элемента стека
    public E pop() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        E topElement = arr[size - 1];
        arr[size - 1] = null; // Очищаем ссылку на объект
        size--;
        return topElement;
    }

    // Метод для проверки, пуст ли стек
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для добавления элементов из ArrayList в стек без дубликатов
    public void addAllWithoutDuplicates(ArrayList<E> list) {
        if (list == null || list.isEmpty()) {
            return; // Если список пуст или равен null, ничего не делаем
        }

        for (E element : list) {
            // Проверяем, содержится ли элемент уже в стеке
            if (!containsElement(element)) {
                push(element); // Добавляем элемент, если его нет в стеке
            }
        }
    }

    // Вспомогательный метод для проверки наличия элемента в стеке
    private boolean containsElement(E element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Переопределение метода toString для удобного вывода
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("стек: [");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}