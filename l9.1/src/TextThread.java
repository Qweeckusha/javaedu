class TextThread extends Thread {
    private String text; // Текстовая строка
    private static final Object lock = new Object(); // Общий объект для синхронизации

    // Конструктор
    public TextThread(String text) {
        this.text = text;
    }

    // Синхронизированный метод для вывода текста
    public void printText() {
        synchronized (lock) { // Синхронизация на общем объекте
            System.out.println("ID потока: " + Thread.currentThread().getId());
            System.out.println(text);
        }
    }

    // Переопределение метода run
    @Override
    public void run() {
        printText();
    }
}