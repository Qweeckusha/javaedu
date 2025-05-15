import java.io.*;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        // Хост и порт для подключения к серверу
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Подключение к серверу установлено.");

            // Чтение данных из сокета
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String receivedData;
                System.out.println("Полученные данные:");
                while ((receivedData = in.readLine()) != null) {
                    System.out.println(receivedData);
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка клиента: " + e.getMessage());
        }
    }
}