public class Patient {
    private final String name;
    private final int serviceTime;

    public Patient(String name, int serviceTime) {
        this.name = name;
        this.serviceTime = serviceTime;
    }

    public String getName() {
        return name;
    }

    public int getServiceTime() {
        return serviceTime;
    }
}