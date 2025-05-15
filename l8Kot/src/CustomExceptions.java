// Пользовательские исключения
public class CustomExceptions {
    // Исключение для заполненного контейнера
    public static class ContainerFullException extends Exception {
        public ContainerFullException(String message) {
            super(message);
        }
    }

    // Исключение для пустого контейнера
    public static class ContainerEmptyException extends Exception {
        public ContainerEmptyException(String message) {
            super(message);
        }
    }

    // Исключение для сортировки
    public static class SortException extends Exception {
        public SortException(String message) {
            super(message);
        }
    }

    // Исключение для поиска
    public static class SearchException extends Exception {
        public SearchException(String message) {
            super(message);
        }
    }
}