public class TestMyStackSort {
    public static void main(String[] args) {
        MyStack originalStack = new MyStack();
//-------- Добавляемые элементы --------
        originalStack.push(5);
        originalStack.push(1);
        originalStack.push(3);
        originalStack.push(2);
        originalStack.push(9);
//---------------------------------------
        MyStack clonedStack = (MyStack) originalStack.clone();
        System.out.println("Pre-sorted: " + originalStack);
        originalStack.sort();
        System.out.println("Sorted: " + originalStack);
        System.out.println("\nPre-sorted cloned list: " + clonedStack);

        // Проверка порядка элементов
        System.out.println("\nElements of sorting:");
        String result = ""; // Инициализируем пустую строку
        while (!originalStack.isEmpty()) {
            result += originalStack.pop() + " "; // Добавляем элемент и пробел
        }
        System.out.println(result.trim()); // Убираем лишний пробел в конце
    }
}