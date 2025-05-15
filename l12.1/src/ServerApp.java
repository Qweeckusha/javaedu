import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        // Порт для соединения
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидание подключения клиентов...");

            // Бесконечный цикл для работы сервера
            while (true) {
                // Ожидание подключения клиента
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен.");

                // Создание нового потока для обработки клиента
                new Thread(() -> handleClient(clientSocket)).start();
            }

        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }

    // Метод для обработки клиента
    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            // Чтение текста из файла
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }

            // Фильтрация только английских букв
            String filteredText = fileContent.toString().replaceAll("[^a-zA-Z\\s]", "");

            // Отправка данных клиенту
            out.println(filteredText);
            System.out.println("Данные отправлены клиенту.");

        } catch (IOException e) {
            System.err.println("Ошибка при работе с клиентом: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("Соединение с клиентом закрыто.");
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }
}