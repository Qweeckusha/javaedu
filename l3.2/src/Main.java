public class Main {
    public static void main(String[] args) {
        // Создание объекта MyString2
        MyString2 str1 = new MyString2(new char[]{'H', 'e', 'l', 'l', 'o'});
        MyString2 str2 = new MyString2(new char[]{'H', 'e', 'l', 'l', 'o'});
        MyString2 str3 = new MyString2(new char[]{'W', 'o', 'r', 'l', 'd'});

        // Тестирование методов
        System.out.println("str1: " + str1); // Hello
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // Отрицательное число (Hello < World)

        // Подстроки
        MyString2 subStr = str1.substring(1, 4);
        System.out.println("Substring (1, 4): " + subStr); // ell

        // Преобразование boolean в MyString2
        MyString2 boolStr = MyString2.valueOf(true);
        System.out.println("Boolean value: " + boolStr); // true

        // Преобразование в массив символов
        char[] chars = str1.toChars();
        System.out.println("Chars array: " + Arrays.toString(chars)); // [H, e, l, l, o]
    }
}