// Пользовательские исключения
class ContainerFullException extends Exception {
    public ContainerFullException(String message) {
        super(message);
    }
}

class ContainerEmptyException extends Exception {
    public ContainerEmptyException(String message) {
        super(message);
    }
}

class SortException extends Exception {
    public SortException(String message) {
        super(message);
    }
}

class SearchException extends Exception {
    public SearchException(String message) {
        super(message);
    }
}
