public class Main {
    public static void main(String[] args) {
        // Путь к файлу с текстом
        String filePath = "src/file.txt"; // Убедитесь, что файл paper.txt находится в корне проекта

        // Поиск и вывод всех ссылок на литературу
        LiteratureReferenceFinder.findReferencesInFile(filePath);

        // Пример использования функции isLiteratureReference
        String testLine = "1. Бондарев А.Н., Киричек Р.В. Обзор беспилотных летательных аппаратов общего пользования и регулирования воздушного движения БПЛА в разных странах. Информационные технологии и телекоммуникации. 2016;4(4):13–23.";
        System.out.println("\nПроверка строки: \"" + testLine + "\"");
        System.out.println("Является ссылкой на литературу: " + LiteratureReferenceFinder.isLiteratureReference(testLine));
    }
}


