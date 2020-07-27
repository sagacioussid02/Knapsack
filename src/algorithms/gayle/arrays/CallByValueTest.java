package algorithms.gayle.arrays;

import java.util.Arrays;

public class CallByValueTest {
    
    public static void methodA(int[] arr, MyObjectToTestCallByValue obj) {
        methodB(arr, obj);
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println("Printing obj from method A");
        System.out.println(obj.toString());
        
    }
    
    public static void methodB(int[] arr1, MyObjectToTestCallByValue obj) {
        arr1[0] = 20;
        arr1[1] = 30;
        obj.setName("new Name");
        Arrays.stream(arr1).forEach(System.out::println);
        System.out.println("Printing obj from method B");
        System.out.println(obj.toString());
    }

    public static void main(String[] args) {
        methodA(new int[] {1,2,3,4,5}, new MyObjectToTestCallByValue(1, "name"));
    }

}
