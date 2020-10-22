package algorithms.concepts;

import java.util.Arrays;

public class PassByValue {

	public static void main(String[] args) {

		Balloon red = new Balloon("Red"); //memory reference 50
		Balloon blue = new Balloon("Blue"); //memory reference 100
		int[] arr = new int[] {1,2,3,4};
		int[] p = {21,32,44,51};
	    Arrays.stream(arr).forEach(System.out::println);
	    Arrays.stream(p).forEach(System.out::println);
	    updateArray(arr,p);
	    System.out.println("Updated array is");
	    Arrays.stream(arr).forEach(System.out::println);
	    Arrays.stream(p).forEach(System.out::println);
	    
		
		
		swap(red, blue);
		System.out.println("red color="+red.getColor());
		System.out.println("blue color="+blue.getColor());
		
		foo(blue);
		System.out.println("blue color="+blue.getColor());
		
		Balloon alsoRed = new Balloon("Red");
		System.out.println(red.equals(alsoRed));
		
	}

	private static void foo(Balloon balloon) { //baloon=100
		balloon.setColor("Red"); //baloon=100
		balloon = new Balloon("Green"); //baloon=200
		balloon.setColor("Blue"); //baloon = 200
	}

	//Generic swap method
	public static void swap(Object o1, Object o2){
		Object temp = o1;
		o1=o2;
		o2=temp;
	}
	
	public static void updateArray(int[] arr,int[] p) {
		//arr = new int[]{2,3,4,5};
		arr[2] = 7890;
		p[3] = 9999;
	}

}

class Balloon{
	private String color;

	public Balloon(){}
	
	public Balloon(String c){
		this.color=c;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
