public class Car {
    private String name; // Название автомобиля
    private Priority priority; // Приоритет автомобиля
    private int arrivalOrder; // Порядковый номер прибытия

    public Car(String name, Priority priority, int arrivalOrder) {
        this.name = name;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public String toString() {
        return name + " (" + priority + ")";
    }
}