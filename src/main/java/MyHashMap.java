import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Math.abs;

public class MyHashMap <K,V> {

    // Розмір колекції
    private int size = 0;

    // Розмір таблиці мапи
    private static int mapTableSize = 16;

    private Node<K,V>[] mapTable;

    MyHashMap(){
        mapTable = (Node<K,V>[]) new Node[mapTableSize];
    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : abs(Objects.hashCode(key)) % mapTableSize;
    }

    // put(Object key, Object value) - додає пару ключ + значення

    public void put(Object key, Object value) {
        int newNodeHash = hash(key);
        Node newNode = new Node(newNodeHash, key, value, null);

        if (mapTable[newNodeHash] == null) {
            mapTable[newNodeHash] = newNode;
            size++;
        }
        else {
            Node tmpNode = mapTable[newNodeHash];
            while (tmpNode.next != null) {
                if(tmpNode.key == newNode.key) {
                    tmpNode.value = newNode.value;
                    return;
                }
                tmpNode = tmpNode.next;
            }
            if(tmpNode.key == newNode.key) {
                tmpNode.value = newNode.value;
                return;
            }
            tmpNode.next = newNode;
            size++;
        }
    }


    // remove(Object key) - видаляє пару за ключем
    public void remove(Object key){

        int newNodeHash = hash(key);

        if (mapTable[newNodeHash] == null) {
            return;
        }
        else {
            Node tmpNode = mapTable[newNodeHash];
            Node prevNode = tmpNode;

            if (tmpNode.next == null && tmpNode.key == key) {
                mapTable[newNodeHash] = null;
                size--;
                return;
            }

            if (tmpNode.next == null && tmpNode.key != key) {
                return;
            }

            if (tmpNode.next != null && tmpNode.key == key) {
                mapTable[newNodeHash] = tmpNode.next;
                size--;
                return;
            }

            while (tmpNode.next != null) {
                if(tmpNode.key == key) {
                    prevNode.next = tmpNode.next;
                    size--;
                    return;
                }
                prevNode = tmpNode;
                tmpNode = tmpNode.next;
                if(tmpNode.key == key) {
                    prevNode.next = tmpNode.next;
                    size--;
                    return;
                }
            }
        }
    }

    // clear() - очищає колекцію
    public void clear() {
        if (mapTable != null && size > 0) {
            for (int i = 0; i < mapTable.length; i++) {
                mapTable[i] = null;
                size = 0;
            }
        }
    }

    // size() - повертає розмір колекції
    public int size() {
        return size;
    }

    // get(Object key)  - повертає значення (Object value) за ключем
    public Object get(Object key) {

        int newNodeHash = hash(key);

        if (mapTable[newNodeHash] == null) {
            return null;
        } else {
            Node tmpNode = mapTable[newNodeHash];

            while (tmpNode != null) {
                if(tmpNode.key == key) {
                    return tmpNode.value;
                   }
                tmpNode = tmpNode.next;
            }

        }
        return null;
    }


    @Override
    // toSting() - повертає колекцію у вигляді рядка
    public String toString(){
        String res = "";
        for (int i = 0; i < mapTableSize; i++) {
            res += "\n" + (100+i+"").substring(1) + ": ";
            if(mapTable[i] != null) {
                Node tmpNode = mapTable[i];
                res += "[" + tmpNode.toString() + "] ";
                while (tmpNode.next != null) {
                    tmpNode = tmpNode.next;
                    res += "[" + tmpNode.toString() + "] ";
                }
            }
        }
        return res;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

}