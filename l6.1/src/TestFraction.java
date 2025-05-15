import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestFraction {
    public static void main(String[] args) {
        // Создаем список дробей
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 6));
        fractions.add(new Fraction(-3, 9));
        fractions.add(new Fraction(2, 6));
        fractions.add(new Fraction(-7, 9));

        System.out.println("Исходный список: " + fractions);

        // Сортировка по возрастанию
        sortAndPrint(fractions, Fraction.ASCENDING_COMPARATOR, "По возрастанию");

        // Сортировка по убыванию
        sortAndPrint(fractions, Fraction.DESCENDING_COMPARATOR, "По убыванию");

        // Сортировка по возрастанию абсолютных значений
        sortAndPrint(fractions, Fraction.ABSOLUTE_ASCENDING_COMPARATOR, "По возрастанию абсолютных значений");

        // Сортировка по убыванию абсолютных значений
        sortAndPrint(fractions, Fraction.ABSOLUTE_DESCENDING_COMPARATOR, "По убыванию абсолютных значений");
    }

    // Метод для сортировки и вывода списка
    private static void sortAndPrint(List<Fraction> fractions, Comparator<Fraction> comparator, String message) {
        List<Fraction> sortedFractions = new ArrayList<>(fractions); // Создаем копию списка
        sortedFractions.sort(comparator); // Сортируем
        System.out.println(message + ": " + sortedFractions); // Выводим результат
    }
}
