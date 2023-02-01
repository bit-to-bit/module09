import java.awt.*;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyArrayList<E>  {

    private static final int DEFAULT_SIZE = 5;
    private static Object[] elementData;
    private int size = 0;


    // конструктор для створення MyArrayList заданого розміру
    public MyArrayList(int arraySize) {
        if (arraySize > 0) {
            elementData = new Object[arraySize];
        } else if (arraySize == 0) {
            elementData = new Object[DEFAULT_SIZE];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    arraySize);
        }
    }

    // конструктор для створення пустого MyArrayList

    public MyArrayList() {
           elementData = new Object[DEFAULT_SIZE];
    }

    // add(Object value) - додає елемент в кінець
    public void add(Object value) {

        if (elementData.length == size) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        elementData[size] = value;
        size++;
    }

    // remove(int index) - видаляє елемент із вказаним індексом
    public void remove(int index){
        Objects.checkIndex(index, size);

        for (int i = index; i < size; i++) {
            if (i == size - 1) {elementData[i] = null;}
            else {elementData[i] = elementData[i+1];}
        }
        size--;
    }

    //clear() - очищає колекцію
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    //size() - повертає розмір колекції
    public int size() {
           return size;
    }

    //get(int index) - повертає елемент за індексом
    public E get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    // Перевизначимо метод toString() для зручності тестів
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

    for (int i = 0; i < size; i++) {
        res.append(", ").append(elementData[i]);
    }

    if (res.length()>2) {
        res = new StringBuilder(res.substring(2));}
        return "{" + res + "}";
}

}
