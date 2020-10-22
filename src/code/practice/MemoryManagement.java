package code.practice;

import java.util.ArrayList;
import java.util.List;

public class MemoryManagement {

	public static void main(String[] args) {
		A();
	}
	
	public static void A() {
		Integer x = new Integer(10);
		Integer y = 10;
		Integer z = new Integer(10);
		System.out.println(x==y);
		System.out.println(y.equals(x));
		System.out.println(x==z);
		System.out.println(x.equals(z));
		System.out.println(new Integer(10)==y);
		B();
		System.out.println(x);
		System.out.println(y);
		C(x);
		System.out.println(x);
		int[] arr = new int[] {1,2,3,4};
		D(arr);
		System.out.println(arr[0]);
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(106767);
		E(myList);
		myList.stream().forEach(System.out::println);
	}

	private static void E(List<Integer> myList) {
		myList.add(345);
	}

	private static void D(int[] arr) {
		arr[0] = 100;
	}

	private static void C(Integer x) {
		//x = new Integer(20);
		x+=20;
	}

	private static void B() {
		Integer x = new Integer(20);
		Integer y = 20;
	}

}
