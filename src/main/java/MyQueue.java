import java.util.Objects;

public class MyQueue <E> {
    // Size of MyLinkedList
    private int size = 0;

    // Pointer to first node.
    private Node<E> firstNode;

    //  Pointer to last node.
    private Node<E> lastNode;

    // пустий конструктор для створення нового обєкту
    public MyQueue() {
    }

    // add(Object value) - додає елемент в кінець
    public void add(E element) {

        Node<E> currentNode = new Node<E>();
        currentNode.item = element;

        if (size == 0) {
            firstNode = currentNode;
            lastNode = currentNode;
        } else {
            lastNode.next = currentNode;
            currentNode.prev = lastNode;
            lastNode = currentNode;
        }

        size++;
    }

    //clear() - очищає колекцію
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    // size() - повертає розмір колекції
    public int size() {
        return size;
    }

    // peek() - повертає перший елемент з черги
    public E peek() {
        return firstNode == null ? (E) null : (E) firstNode.item;
    }

    // poll() - повертає перший елемент з черги і видаляє його з колекції
    public E poll() {

        E res = size == 0 ? null: firstNode.item;

        if (size == 0) {
            return (E) res;
        }

        if (size == 1) {
            firstNode = null;
            lastNode = null;
            size--;
            return (E) res;
        }

        firstNode = firstNode.next;
        firstNode.prev = null;
        size--;

        return (E) res;
    }


    // перевизначимо метод toString() для тестів
    @Override
    public String toString() {
        String res = "";

        Node tmpNode = firstNode;

        for (int i = 0; i < size; i++) {
            if (i > 0) {tmpNode = tmpNode.next;}
            res += ", " + tmpNode.item;
        }

        if (res.length()>2) {res = res.substring(2);}

        return "{" + res + "}";
    }

    // визначаємо класс Node
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
    }
}
