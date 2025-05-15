import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Car> queue1 = new PriorityQueue<>(new AmbulanceFirstComparator());
        PriorityQueue<Car> queue2 = new PriorityQueue<>(new PoliceFirstComparator());

        // Добавляем автомобили в очереди
        queue1.add(new Car("Car1", Priority.NORMAL, 1));
        queue1.add(new Car("Police1", Priority.POLICE, 2));
        queue1.add(new Car("Ambulance1", Priority.AMBULANCE, 3));
        queue1.add(new Car("Car2", Priority.NORMAL, 4));

        queue2.addAll(queue1); // Копируем автомобили во вторую очередь

        // Извлекаем автомобили из первой очереди (высший приоритет у AMBULANCE)
        System.out.println("Очередь 1 (высший приоритет у AMBULANCE):");
        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }

        // Извлекаем автомобили из второй очереди (высший приоритет у POLICE)
        System.out.println("\nОчередь 2 (высший приоритет у POLICE):");
        while (!queue2.isEmpty()) {
            System.out.println(queue2.poll());
        }
    }
}