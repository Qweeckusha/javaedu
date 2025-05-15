public class IntegerContainer {
    private static final int MAX_SIZE = 10; // Максимальный размер контейнера
    private int[] data; // Массив для хранения данных
    private int size; // Текущее количество элементов

    // Конструктор
    public IntegerContainer() {
        data = new int[MAX_SIZE];
        size = 0;
    }

    // Метод добавления элемента
    public void push(int value) throws ContainerFullException {
        if (size == MAX_SIZE) {
            throw new ContainerFullException("Контейнер заполнен. Невозможно добавить элемент.");
        }
        data[size] = value;
        size++;
    }

    // Метод удаления элемента
    public int pop() throws ContainerEmptyException {
        if (size == 0) {
            throw new ContainerEmptyException("Контейнер пуст. Невозможно удалить элемент.");
        }
        int removedValue = data[size - 1];
        data[size - 1] = 0; // Очищаем значение
        size--;
        return removedValue;
    }

    // Метод сортировки элементов
    public void sort() throws SortException {
        if (size == 0) {
            throw new SortException("Контейнер пуст. Невозможно выполнить сортировку.");
        }

        // Проверяем, что не все элементы равны
        boolean allEqual = true;
        for (int i = 1; i < size; i++) {
            if (data[i] != data[0]) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) {
            throw new SortException("Все элементы равны. Сортировка невозможна.");
        }

        // Выполняем сортировку пузырьком
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Метод поиска элемента по значению
    public int search(int value) throws SearchException {
        int count = 0;
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                count++;
                index = i;
            }
        }

        if (count == 0) {
            throw new SearchException("Элемент " + value + " не найден в контейнере.");
        } else if (count > 1) {
            throw new SearchException("Элемент " + value + " встречается более одного раза.");
        }

        return index;
    }

    // Переопределение метода toString для удобного вывода
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Контейнер: [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}