public class MyTimeClient {
    public static void main(String[] args) {
        // Создание объектов MyTime
        MyTime time1 = new MyTime(); // Текущее время
        MyTime time2 = new MyTime(555550000L); // Время из миллисекунд
        MyTime time3 = new MyTime(5, 23, 55); // Указанное время

        // Вывод значений полей данных в формате часы:минуты:секунды
        System.out.println("Текущее время: " + time1);
        System.out.println("Время из миллисекунд (555550000): " + time2);
        System.out.println("Указанное время (5:23:55): " + time3);
    }
}