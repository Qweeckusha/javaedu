public class MyString2 {
    private char[] chars;

    // Конструктор для создания объекта из массива символов
    public MyString2(char[] chars) {
        this.chars = chars.clone(); // Создаем копию массива для безопасности
    }

    // Метод substring(int begin): возвращает подстроку, начиная с индекса begin
    public MyString2 substring(int begin) {
        if (begin < 0 || begin > chars.length) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + begin);
        }
        char[] subArray = new char[chars.length - begin];
        System.arraycopy(chars, begin, subArray, 0, subArray.length);
        return new MyString2(subArray);
    }

    // Метод substring(int begin, int end): возвращает подстроку от begin до end
    public MyString2 substring(int begin, int end) {
        if (begin < 0 || end > chars.length || begin > end) {
            throw new IndexOutOfBoundsException("Недопустимые индексы: begin=" + begin + ", end=" + end);
        }
        char[] subArray = new char[end - begin];
        System.arraycopy(chars, begin, subArray, 0, subArray.length);
        return new MyString2(subArray);
    }

    // Метод equals(Object obj): сравнивает объекты на равенство
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Один и тот же объект
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Разные типы или null
        }
        MyString2 other = (MyString2) obj;
        return Arrays.equals(chars, other.chars); // Сравнение массивов символов
    }

    // Метод compareTo(MyString2 obj): сравнивает объекты лексикографически
    public int compareTo(MyString2 obj) {
        if (obj == null) {
            throw new NullPointerException("Сравниваемый объект не может быть null");
        }
        int minLength = Math.min(chars.length, obj.chars.length);
        for (int i = 0; i < minLength; i++) {
            if (chars[i] != obj.chars[i]) {
                return chars[i] - obj.chars[i]; // Лексикографическое сравнение
            }
        }
        return chars.length - obj.chars.length; // Если префикс одинаковый, сравниваем длины
    }

    // Метод toChars(): возвращает массив символов
    public char[] toChars() {
        return chars.clone(); // Возвращаем копию массива для безопасности
    }

    // Метод valueOf(boolean b): статический метод для создания MyString2 из boolean
    public static MyString2 valueOf(boolean b) {
        return b ? new MyString2(new char[]{'t', 'r', 'u', 'e'}) : new MyString2(new char[]{'f', 'a', 'l', 's', 'e'});
    }

    // Переопределение метода toString() для удобного вывода
    @Override
    public String toString() {
        return new String(chars);
    }
}