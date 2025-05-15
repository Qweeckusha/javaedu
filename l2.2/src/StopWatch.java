public class StopWatch {
    private long startTime;
    private long endTime;

    // Безаргументный конструктор
    public StopWatch() {
        this.startTime = System.currentTimeMillis(); // Инициализация startTime текущим временем
    }

    // Getter для startTime
    public long getStartTime() {
        return startTime;
    }

    // Getter для endTime
    public long getEndTime() {
        return endTime;
    }

    // Метод start() сбрасывает startTime до текущего времени
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    // Метод stop() присваивает endTime текущее время
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    // Метод getElapsedTime() возвращает прошедшее время в миллисекундах
    public long getElapsedTime() {
        return endTime - startTime;
    }
}