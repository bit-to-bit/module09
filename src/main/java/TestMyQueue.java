public class TestMyQueue {


        public static void main(String[] args) {

            MyQueue<String> myQueue = new MyQueue<>();

            System.out.println("\nТест методу peek(), коли черга ще пуста:");
            System.out.println("Перший елемент з коллекції peek() = " + myQueue.peek());

            System.out.println("\nТест методу add():");
            System.out.println("Додаємо в колекцію 11 елементів. У результаті отримали колекцію: ");

            for (int i = 0; i < 11; i++) {
                myQueue.add("man" + (100 + i));
            }

            System.out.println(myQueue);

            System.out.println("\nТест методу size():");
            System.out.println("myQueue.size() = " + myQueue.size());

            System.out.println("\nТест методу peek():");
            System.out.println("Перший елемент з коллекції peek() = " + myQueue.peek());

            System.out.println("\nТест методу poll():");
            System.out.println("Перший елемент з коллекції poll() = " + myQueue.poll());
            System.out.println("Черга тепер має вигляд: " + myQueue.toString());
            System.out.println("Повторимо ще раз. Перший елемент з коллекції poll() = " + myQueue.poll());
            System.out.println("Черга тепер має вигляд: " + myQueue.toString());

            System.out.println("\nТест методу clear():");
            myQueue.clear();
            System.out.println("Почистили колекцію. Надрукуємо колекцію, що маємо наразі: " + myQueue.toString());

            System.out.println("\nЩе один тест методу add():");
            System.out.println("Додамо один елемент: ");
            myQueue.add("robot100");
            System.out.println("Черга тепер має вигляд: " + myQueue.toString());
            System.out.println("Витягнемо елемент з коллекції методом poll() = " + myQueue.poll());
            System.out.println("Черга тепер має вигляд: " + myQueue.toString());
            System.out.println("Витягнемо ще елемент з коллекції методом poll() = " + myQueue.poll());
            System.out.println("Черга тепер має вигляд: " + myQueue.toString());


            System.out.println("\nТест методу size():");
            System.out.println("myQueue.size() = " + myQueue.size());

        }

    }
