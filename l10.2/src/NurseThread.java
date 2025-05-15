import java.util.concurrent.BlockingQueue;

class NurseThread extends Thread {
    private final BlockingQueue<Patient> queue;
    private final String nurseName;

    public NurseThread(BlockingQueue<Patient> queue, String nurseName) {
        this.queue = queue;
        this.nurseName = nurseName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Patient patient = queue.poll(); // Извлекаем пациента из очереди
                if (patient == null) {
                    break; // Если очередь пуста, завершаем работу
                }

                System.out.println(nurseName + " начала обслуживать " + patient.getName());
                Thread.sleep(patient.getServiceTime()); // Имитация времени обслуживания
                System.out.println(nurseName + " закончила обслуживать " + patient.getName() +
                        " за " + patient.getServiceTime() + " мс");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}