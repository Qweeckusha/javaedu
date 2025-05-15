public class TestGenericStack {
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Удаленный элемент: " + stack.pop());
        System.out.println(stack);

        System.out.println("Стек пуст? " + stack.isEmpty());
    }
}