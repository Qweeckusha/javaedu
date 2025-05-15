import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFraction {
    public static void main(String[] args) {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(-3, 4));
        fractions.add(new Fraction(5, 6));
        fractions.add(new Fraction(-7, 8));

        System.out.println("Исходный список: " + fractions);

        // Сортировка по возрастанию
        Collections.sort(fractions, new Fraction.AscendingComparator());
        System.out.println("По возрастанию: " + fractions);

        // Сортировка по убыванию
        Collections.sort(fractions, new Fraction.DescendingComparator());
        System.out.println("По убыванию: " + fractions);

        // Сортировка по возрастанию абсолютных значений
        Collections.sort(fractions, new Fraction.AbsoluteAscendingComparator());
        System.out.println("По возрастанию абсолютных значений: " + fractions);

        // Сортировка по убыванию абсолютных значений
        Collections.sort(fractions, new Fraction.AbsoluteDescendingComparator());
        System.out.println("По убыванию абсолютных значений: " + fractions);
    }
}