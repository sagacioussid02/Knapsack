package datastructures.basic.tries;

public class TriesDriver {

	public static void main(String[] args) {
		Tries tries = new Tries();
		tries.addNode("hello");
		tries.addNode("how");
		tries.addNode("flower");
		tries.addNode("flow");
		
		System.out.println(tries.searchNode("how"));
		System.out.println(tries.searchNode("are"));
		System.out.println(tries.isPrefix("flow"));
		System.out.println(tries.isPrefix("flo"));
		System.out.println(tries.isPrefix("flown"));
	}

}
