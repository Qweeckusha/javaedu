import java.util.*;

class Fraction implements Comparable<Fraction> {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    // Приведение дроби к нормализованному виду (сокращение)
    private void normalize() {
        // Находим НОД числителя и знаменателя
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

        // Сокращаем дробь, деля числитель и знаменатель на НОД
        numerator /= gcd;
        denominator /= gcd;

        // Если знаменатель отрицательный, меняем знаки числителя и знаменателя
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // НОД (наибольший общий делитель)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Переопределение метода compareTo для интерфейса Comparable
    @Override
    public int compareTo(Fraction other) {
        // Сравниваем дроби через их значения (числитель/знаменатель)
        return Double.compare((double) numerator / denominator, (double) other.numerator / other.denominator);
    }

    // Переопределение метода toString для удобного вывода
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Компараторы - классы, задающие правила сравнения
    public static class AscendingComparator implements Comparator<Fraction> {
        @Override
        public int compare(Fraction f1, Fraction f2) {
            return f1.compareTo(f2); // По возрастанию
        }
    }

    public static class DescendingComparator implements Comparator<Fraction> {
        @Override
        public int compare(Fraction f1, Fraction f2) {
            return f2.compareTo(f1); // По убыванию
        }
    }

    public static class AbsoluteAscendingComparator implements Comparator<Fraction> {
        @Override
        public int compare(Fraction f1, Fraction f2) {
            return Double.compare(Math.abs((double) f1.numerator / f1.denominator),
                    Math.abs((double) f2.numerator / f2.denominator)); // По возрастанию абсолютных значений
        }
    }

    public static class AbsoluteDescendingComparator implements Comparator<Fraction> {
        @Override
        public int compare(Fraction f1, Fraction f2) {
            return Double.compare(Math.abs((double) f2.numerator / f2.denominator),
                    Math.abs((double) f1.numerator / f1.denominator)); // По убыванию абсолютных значений
        }
    }
}