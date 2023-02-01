public class TestMyStack {

    public static void main(String[] args) {

        MyStack<String> myStack = new MyStack();

        System.out.println("\nТест методу peek(), коли черга ще пуста:");
        System.out.println("Перший елемент з коллекції peek() = " + myStack.peek());

        System.out.println("\nТест методу push(), додамо 11 Cat - Dog:");
        for (int i = 0; i < 11; i++) {

            myStack.push((i%2 == 1?"Cat":"Dog") + "_" + ((100 + i) + "").substring(1));
        }

        System.out.println("myStack = " + myStack);

        System.out.println("\nТест методу remove():");
        System.out.println("Видаляємо об'єкт з індексом 3 = remove(3). В результаті отримали колекцію:" );
        myStack.remove(3);
        System.out.println("myStack = " + myStack);

        System.out.println("\nЩе раз тест методу peek(), коли черга не пуста:");
        System.out.println("Перший елемент з коллекції peek() = " + myStack.peek());

        System.out.println("\nТест методу size():");
        System.out.println("myStack.size() = " + myStack.size());

        System.out.println("\nТест методу pop():");
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack = " + myStack);

        System.out.println("\nЩе тест методу pop():");
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack = " + myStack);

        System.out.println("\nТест методу clear():");
        myStack.clear();
        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack = " + myStack);

        System.out.println("myStack.pop() = " + myStack.pop());


    }



}
