public class Main {
    public static void main(String[] args) {
        // Буфер (ограниченная очередь вместимостью в 5) для всех частей
        Buffer<Part> bufferC = new Buffer<>(5);
        Buffer<Part> bufferD = new Buffer<>(5);
        Buffer<Part> bufferB = new Buffer<>(5);
        Buffer<Part> bufferA = new Buffer<>(5);
        Buffer<Product> productBuffer = new Buffer<>(100);

        Thread statsThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Вывод каждые 5 секунд
                    System.out.println("======= Статистика =======\n" +
                            "Buffer A: " + bufferA.size() + "\n" +
                            "Buffer B: " + bufferB.size() + "\n" +
                            "Buffer C: " + bufferC.size() + "\n" +
                            "Buffer D: " + bufferD.size() + "\n" +
                            "Product Buffer: " + productBuffer.size() + "\n" +
                            "==========================");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        statsThread.setDaemon(true);
        statsThread.start();

        // Сборка части C и D
        Thread producerC = new Thread(new Producer(bufferC, "C", 2));
        Thread producerD = new Thread(new Producer(bufferD, "D", 1));

        // Собрана часть B
        Thread assemblerB = new Thread(new Assembler(bufferC, bufferD, bufferB, "-------------- Часть ***B*** собрана --------------", 3));

        // Сборка части A
        Thread producerA = new Thread(new Producer(bufferA, "A", 1));

        // Конечный продукт из A и B
        Thread finalAssembler = new Thread(new Assembler(bufferA, bufferB, productBuffer, "-------------- ***Product*** собран --------------", 2));

        // Start all threads
        producerC.start();
        producerD.start();
        assemblerB.start();
        producerA.start();
        finalAssembler.start();
    }
}