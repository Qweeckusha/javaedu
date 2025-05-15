import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен. Ожидание подключения клиентов...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новый клиент подключен.");

                // Создание обработчика для клиента
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);

                // Запуск обработчика в новом потоке
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }

    // Метод для рассылки сообщений всем клиентам
    public static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) { // Не отправляем сообщение обратно отправителю
                client.sendMessage(message);
            }
        }
    }

    // Удаление клиента из списка
    public static void removeClient(ClientHandler client) {
        clients.remove(client);
        System.out.println("Клиент отключен.");
    }

    // Внутренний класс для обработки клиентов
    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.err.println("Ошибка при создании обработчика клиента: " + e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Получено сообщение: " + message);
                    broadcastMessage(message, this);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении сообщения от клиента: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
                }
                removeClient(this);
            }
        }

        // Метод для отправки сообщения клиенту
        public void sendMessage(String message) {
            out.println(message);
        }
    }
}