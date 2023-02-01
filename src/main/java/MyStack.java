import java.util.Objects;

public class MyStack <E> {
    // Size of MyStack
    private int size = 0;

    // Pointer to first node.
    private Node<E> firstNode;

    //  Pointer to last node.
    private Node<E> lastNode;

    // пустий конструктор для створення нового обєкту
    public MyStack() {
    }

    // push(Object value) - додає елемент в кінець
    public void push(E element) {

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

    // remove(int index) - видаляє елемент за індексом
    public void remove(int index) {

        Objects.checkIndex(index, size);

        Node tmpNode = firstNode;

        for (int i = 0; i <= index; i++) {
            if (i > 0) {tmpNode = tmpNode.next;}
        }

        if (size == 1) {
            firstNode = null;
            lastNode = null;
        }

        else {
            // якщо видаляється перша нода
            if (index == 0) {tmpNode.next.prev = null;
                firstNode = tmpNode.next;}
            // якщо видаляється остання нода
            if (index == size - 1) {tmpNode.prev.next = null;
                lastNode = tmpNode.prev;}
            // якщо видаляється середня нода
            if (index != 0 && index != size - 1) {tmpNode.prev.next = tmpNode.next;
                tmpNode.next.prev = tmpNode.prev;}
        }

        size--;
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
        return lastNode == null ? (E) null : (E) lastNode.item;
    }

    // pop() - повертає перший елемент з черги і видаляє його з колекції
    public E pop() {

        E res = size == 0 ? null: lastNode.item;

        if (size == 0) {
            return (E) res;
        }

        if (size == 1) {
            firstNode = null;
            lastNode = null;
            size--;
            return (E) res;
        }

        lastNode = lastNode.prev;
        lastNode.next = null;
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
