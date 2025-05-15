import java.util.Random;

public class BubbleSortTimer {
    public static void main(String[] args) {
        // Создание массива случайных чисел
        int size = 50; // Размер массива
        int[] array = generateRandomArray(size);

        // Создание объекта StopWatch
        StopWatch stopWatch = new StopWatch();

        // Начало замера времени
        stopWatch.start();

        // Сортировка массива методом пузырька с отслеживанием прогресса
        bubbleSortWithProgress(array, stopWatch);

        // Остановка замера времени
        stopWatch.stop();

        // Вывод времени выполнения
        System.out.println("\nВремя выполнения сортировки: " + stopWatch.getElapsedTime() + " миллисекунд");
    }

    // Метод для генерации массива случайных чисел
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
        return array;
    }

    // Метод для сортировки массива методом пузырька с отслеживанием прогресса
    private static void bubbleSortWithProgress(int[] array, StopWatch stopWatch) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            // Расчет прогресса
            double progress = ((double) i / (n - 1)) * 100;

            // Вывод прогресса
            if (progress > 0) { // Выводить прогресс при любом значении больше 0
                try {
                    Thread.sleep(500); // Приостановка на 500 миллисекунд
                } catch (InterruptedException e) {
                    System.err.println("Пауза была прервана: " + e.getMessage());
                    Thread.currentThread().interrupt(); // Восстановление статуса прерывания
                }
                System.out.printf("Прогресс сортировки: %.2f%%%n", progress);
            }
        }
    }
}