import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем общий список для хранения строк
        ArrayList<String> list = new ArrayList<>();

        // Создаем и запускаем дочерний поток для сортировки
        Thread sortingThread = new Thread(() -> {
            while (true) {
                try {
                    // Засыпаем на 5 секунд
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Поток сортировки был прерван.");
                    return;
                }

                // Синхронизируем доступ к списку
                synchronized (list) {
                    if (!list.isEmpty()) {
                        System.out.println("\nСортирую список...");
                        System.out.println("\n(Для прерывания потока нажмите Enter в пустой строке)");
                        Collections.sort(list); // Лексикографическая сортировка
                        System.out.println("Отсортированный список: " + list);
                    }
                }
            }
        });
        sortingThread.start();

        // Главный поток для ввода строк
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки (пустая строка для завершения):");

        while (true) {
            String input = scanner.nextLine();

            // Если введена пустая строка, завершаем ввод
            if (input.isEmpty()) {
                break;
            }

            // Разрезаем длинные строки на части по 80 символов
            for (int i = 0; i < input.length(); i += 80) {
                String substring = input.substring(i, Math.min(i + 80, input.length()));

                // Синхронизируем добавление в список
                synchronized (list) {
                    list.add(substring);
                }
            }
        }

        // Прерываем дочерний поток
        sortingThread.interrupt();

        // Выводим окончательное состояние списка
        synchronized (list) {
            System.out.println("\nОкончательное состояние списка:");
            System.out.println(list);
        }

        scanner.close();
    }
}