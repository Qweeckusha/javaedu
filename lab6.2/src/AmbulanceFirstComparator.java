import java.util.Comparator;

public class AmbulanceFirstComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        // Сначала сравниваем приоритеты
        if (c1.getPriority() != c2.getPriority()) {
            return c2.getPriority().ordinal() - c1.getPriority().ordinal();
        }
        // Если приоритеты равны, сравниваем порядок прибытия
        return Integer.compare(c1.getArrivalOrder(), c2.getArrivalOrder());
    }
}