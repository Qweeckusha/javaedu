public class Producer implements Runnable {
    protected final Buffer<Part> outputBuffer;
    protected final String partType;
    protected final int productionTime;

    public Producer(Buffer<Part> outputBuffer, String partType, int productionTime) {
        this.outputBuffer = outputBuffer;
        this.partType = partType;
        this.productionTime = productionTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(productionTime * 1000L); // Convert seconds to milliseconds
                Part part = new Part(partType);
                outputBuffer.put(part);
                System.out.println("Деталь " + part.getType() + " собрана, её ID" + part.getId());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}