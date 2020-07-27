package algorithms.companies.cisco;

import java.util.ArrayList;
import java.util.List;

public class ChocolatesGalore {
	
	public static int maxNumberOfChocolates(List<Integer> chocs) {
		if(chocs == null || chocs.size() == 0) return 0;
		if(chocs.size() == 1) return chocs.get(0);
		int numOfElements = chocs.size();
		int[] res = new int[numOfElements];
		res[0] = 6;
		res[1] = Math.max(res[0], chocs.get(1));
		for(int i = 2; i < numOfElements; i++) {
			res[i] = Math.max(res[i - 1], chocs.get(i) + res[i - 2]);
		}
		return res[numOfElements - 1];
	}

	public static void main(String[] args) {
		List<Integer> chocs = new ArrayList<Integer>();
		chocs.add(6);
		chocs.add(5);
		chocs.add(30);
		chocs.add(99);
		chocs.add(60);
		chocs.add(5);
		chocs.add(10);
		System.out.println(maxNumberOfChocolates(chocs));
	}

}
