import java.util.HashMap;

public class TestMyHashMap {

    public static void main(String[] args) {

        MyHashMap <Integer, String> myMap = new MyHashMap<>();

        for (int i = 0; i < 50; i++) {

            myMap.put(i, "Bird" + i);
        }

        myMap.put(8, "BatMan");

        System.out.println("hMap.size() = " + myMap.size());

        System.out.println("myMap.toString() = " + myMap.toString());

        myMap.remove(5);
        myMap.remove(15);
        myMap.remove(47);

        System.out.println("myMap.size() = " + myMap.size());
        System.out.println("myMap.toString() = " + myMap.toString());

        System.out.println("\nmyMap.get(31) = " + myMap.get(31));
        System.out.println("\nmyMap.get(10000) = " + myMap.get(10000));
        System.out.println("\nmyMap.get(38) = " + myMap.get(38));
        System.out.println("\nmyMap.get(0) = " + myMap.get(0));

        myMap.clear();

        System.out.println("myMap.toString() = " + myMap.toString());
        System.out.println("myMap.size() = " + myMap.size());

        myMap.clear();
        System.out.println("myMap.size() = " + myMap.size());

    }




}
