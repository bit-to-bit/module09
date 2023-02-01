import java.util.LinkedList;

public class TestMyLinkedList {

    public static void main(String[] args) {

        LinkedList<String> myArray = new LinkedList<>();

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        System.out.println("\nТест методу add():");
        System.out.println("Додаємо в колекцію 21 елемент. У результаті отримали колекцію: ");

        for (int i = 0; i < 21; i++) {
            myLinkedList.add(i*10);
        }

        System.out.println(myLinkedList);

        System.out.println("\nТест методу size():");
        System.out.println("myLinkedList.size() = " + myLinkedList.size());

        System.out.println("\nТест методу remove():");
        myLinkedList.remove(0);
        System.out.println("Видалили 1-й елемент: ");
        System.out.println(myLinkedList);
        myLinkedList.remove(5);
        System.out.println("Видалили 6-й елемент: ");
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println("Видалили 1-й елемент: ");
        System.out.println(myLinkedList);
        myLinkedList.remove(myLinkedList.size()-1);
        System.out.println("Видалили останній елемент: ");
        System.out.println(myLinkedList);

        System.out.println("\nТест методу size():");
        System.out.println("myLinkedList.size() = " + myLinkedList.size());


        System.out.println("\nТест методу get():");
        System.out.println("Перший елемент з коллекції = " + myLinkedList.get(0));
        System.out.println("Десятий елемент з коллекції = " + myLinkedList.get(9));
        System.out.println("Останній елемент з коллекції = " + myLinkedList.get(myLinkedList.size()-1));

        System.out.println("\nТест методу clear():");
        myLinkedList.clear();
        System.out.println("Почистили колекцію. Надрукуємо колекцію, що маємо наразі: " + myLinkedList.toString());

        System.out.println("\nТест методу size():");
        System.out.println("myLinkedList.size() = " + myLinkedList.size());

    }

}
