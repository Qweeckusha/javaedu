import java.util.Comparator;

public class Fraction implements Comparable<Fraction> {
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
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

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
        return Double.compare((double) numerator / denominator, (double) other.numerator / other.denominator);
    }

    // Переопределение метода toString для удобного вывода
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Статические компараторы (реализованы через лямбда-выражения)
    public static final Comparator<Fraction> ASCENDING_COMPARATOR = (f1, f2) -> f1.compareTo(f2);
    public static final Comparator<Fraction> DESCENDING_COMPARATOR = (f1, f2) -> f2.compareTo(f1);

    public static final Comparator<Fraction> ABSOLUTE_ASCENDING_COMPARATOR = (f1, f2) ->
            Double.compare(Math.abs((double) f1.getNumerator() / f1.getDenominator()),
                    Math.abs((double) f2.getNumerator() / f2.getDenominator()));

    public static final Comparator<Fraction> ABSOLUTE_DESCENDING_COMPARATOR = (f1, f2) ->
            Double.compare(Math.abs((double) f2.getNumerator() / f2.getDenominator()),
                    Math.abs((double) f1.getNumerator() / f1.getDenominator()));
}