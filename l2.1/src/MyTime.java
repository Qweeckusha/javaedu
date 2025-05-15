public class MyTime {
    private int hour;
    private int minute;
    private int second;

    // Безаргументный конструктор (использует текущее время)
    public MyTime() {
        setTime(System.currentTimeMillis());
    }

    // Конструктор с указанным временем в миллисекундах
    public MyTime(long elapsedTime) {
        setTime(elapsedTime);
    }

    // Конструктор с указанными часами, минутами и секундами
    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

// Геттеры позволят гибко настраивать методы инкапсуляции
//    // Getter для поля hour
//    public int getHour() {
//        return hour;
//    }
//
//    // Getter для поля minute
//    public int getMinute() {
//        return minute;
//    }
//
//    // Getter для поля second
//    public int getSecond() {
//        return second;
//    }

    // Метод для установки времени на основе прошедшего времени в миллисекундах
    public void setTime(long elapsedTime) {
        long totalSeconds = elapsedTime / 1000; // Общее количество секунд
        second = (int) (totalSeconds % 60); // Секунды
        long totalMinutes = totalSeconds / 60; // Общее количество минут
        minute = (int) (totalMinutes % 60); // Минуты
        long totalHours = totalMinutes / 60; // Общее количество часов
        hour = (int) (totalHours % 24); // Часы (в пределах суток)
    }

    // Метод для форматированного вывода времени
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}