import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();

        // Создаем список с дубликатами
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2); // Дубликат
        list.add(4);

        // Добавляем элементы из списка в стек
        stack.addAllWithoutDuplicates(list);

        System.out.println(stack); // Вывод: стек: [1, 2, 3, 4]

        // Добавляем еще один список
        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(5);
        anotherList.add(3); // Дубликат
        anotherList.add(6);

        stack.addAllWithoutDuplicates(anotherList);

        System.out.println(stack); // Вывод: стек: [1, 2, 3, 4, 5, 6]
    }
}