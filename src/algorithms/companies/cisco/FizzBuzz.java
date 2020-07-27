package algorithms.companies.cisco;

public class FizzBuzz {
	//multiple of 3 and 5 then print fizzbuzz
	//multiple of 3 - fizz
	//multiple of 5 - buzz
	//otherwise n
	public static void fizzbuzz(int n) {
		if(n % 3 == 0 && n % 5 == 0) {
			System.out.println("fizzbuzz");
		} else if(n % 3 == 0) {
			System.out.println("fizz");
		} else if(n % 5 == 0) {
			System.out.println("buzz");
		} else {
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		fizzbuzz(15);
		fizzbuzz(5);
		fizzbuzz(3);
		fizzbuzz(7);
		fizzbuzz(0);
		fizzbuzz(-7);
	}

}
