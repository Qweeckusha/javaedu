import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        int nurseCount = 3; // Количество медсестер
        int patientCount = 10; // Количество пациентов

        BlockingQueue<Patient> queue = new LinkedBlockingQueue<>();

        // Создаем пациентов и добавляем их в очередь
        for (int i = 1; i <= patientCount; i++) {
            queue.add(new Patient("Пациент " + i, (int) (Math.random() * 5000 + 1000))); // Время обслуживания от 1 до 5 секунд
        }

        // Создаем потоки для медсестер
        for (int i = 1; i <= nurseCount; i++) {
            new NurseThread(queue, "Медсестра " + i).start();
        }
    }
}