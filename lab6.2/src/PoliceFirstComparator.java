import java.util.Comparator;

public class PoliceFirstComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        // Сначала сравниваем приоритеты
        if (c1.getPriority() != c2.getPriority()) {
            return customPriority(c1.getPriority()) - customPriority(c2.getPriority());
        }
        // Если приоритеты равны, сравниваем порядок прибытия
        return Integer.compare(c1.getArrivalOrder(), c2.getArrivalOrder());
    }

    // Определяем кастомные приоритеты
    private int customPriority(Priority priority) {
        switch (priority) {
            case POLICE: return 2;
            case AMBULANCE: return 1;
            case NORMAL: return 0;
            default: return 0;
        }
    }
}
