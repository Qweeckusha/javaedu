import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

// implements Cloneable помогает работать с методом clone()
public class MyStack implements Cloneable {
    private ArrayList<Comparable> list = new ArrayList<>();

    // Проверка наполняемости списка
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Получение размерности списка
    public int getSize() {
        return list.size();
    }

    // Метод клонирования
    @Override
    public Object clone() {
        try {
            // Создаем поверхностную копию объекта MyStack
            MyStack clonedStack = (MyStack) super.clone();
            // Создаем новый список и копируем в него все элементы из оригинального списка
            clonedStack.list = new ArrayList<>(this.list);
            return clonedStack;
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException("Clone not supported", ex);
        }
    }

    // Получаем последний элемент
    public Comparable peek() {
        return list.get(getSize() - 1);
    }

    // Удаляем последний элемент
    public Comparable pop() {
        Comparable o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    // Добавляем в список
    public void push(Comparable o) {
        list.add(o);
    }

    // Сортировка Collections
    public void sort() {
        Collections.sort(list);
    }

    // Вывод
    @Override
    public String toString() {
        return list.toString();
    }
}