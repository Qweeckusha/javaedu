public class Main {
    public static void main(String[] args) {

        // ---------- Личная инициатива ----------

        // Получаем группу потоков по умолчанию
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while (group.getParent() != null) {
            group = group.getParent();
        }

        // Получаем массив всех активных потоков
        Thread[] defThreads = new Thread[100];
        int count = group.enumerate(defThreads, true);

        // Выводим информацию о потоках
        for (int i = 0; i < count; i++) {
            System.out.println("Системный поток: " + defThreads[i].getName() +
                    ", ID: " + defThreads[i].getId());
        }
        System.out.println("-------------------------------------");

        // ----------------------------------------

        // Массив текстовых строк для потоков
        String[] texts = {
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi.",
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum.",
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia.",
                "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit.",
                "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet.",
                "Consectetur, adipisci velit, sed quia non numquam eius modi tempora.",
                "Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse.",
                "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis."
        };

        // Создаем массив потоков
        Thread[] threads = new Thread[texts.length];

        // Создаем и запускаем потоки
        for (int i = 0; i < texts.length; i++) {
            threads[i] = new TextThread(texts[i]);
            threads[i].start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван: " + e.getMessage());
            }
        }
    }
}