public class Assembler implements Runnable {
    private final Buffer<?> inputBuffer1;
    private final Buffer<?> inputBuffer2;
    private final Buffer<?> outputBuffer;
    private final String outputName;
    private final int assemblyTime;

    public Assembler(Buffer<?> inputBuffer1, Buffer<?> inputBuffer2, Buffer<?> outputBuffer,
                     String outputName, int assemblyTime) {
        this.inputBuffer1 = inputBuffer1;
        this.inputBuffer2 = inputBuffer2;
        this.outputBuffer = outputBuffer;
        this.outputName = outputName;
        this.assemblyTime = assemblyTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object part1 = ((Buffer<Object>) inputBuffer1).take();
                Object part2 = ((Buffer<Object>) inputBuffer2).take();

                Thread.sleep(assemblyTime * 1000L); // Convert seconds to milliseconds

                if (outputBuffer instanceof Buffer<?>) {
                    if ("Product".equals(outputName)) {
                        ((Buffer<Object>) outputBuffer).put(new Product(outputName));
                        System.out.println("Assembled: " + outputName);
                    } else {
                        ((Buffer<Object>) outputBuffer).put(new Part(outputName));
                        System.out.println("Assembled: " + outputName);
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}