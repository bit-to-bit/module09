import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMyArrayList {

    public static void main(String[] args) {

        MyArrayList<String> myArray = new MyArrayList<String>();
        System.out.println("myArray.size() = " + myArray.size());

        for (int i = 0; i < 10; i++) {
            myArray.add("Name " + i);
        }

        System.out.println("myArray = " + myArray);

        myArray.remove(5);
        System.out.println("\nВидалимо 5-й елемент: ");
        System.out.println("myArray = " + myArray);



        myArray.clear();

        System.out.println("myArray = " + myArray);

        System.out.println("myArray.size() after Clear = " + myArray.size());


        System.out.println("myArray.size() = " + myArray.size());


    }

}
