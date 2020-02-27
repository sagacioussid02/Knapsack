package algorithms.companies.amzn;

public class NumberOfWaysToReachSum {

	public static void main(String[] args) {
		System.out.println(numOfWaysDuplicatesAllowed(4));
	}
	
	public static int numOfWaysDuplicatesAllowed(int n) {
		int[] res = new int[n+1];
		res[0] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<n;j++) {
				if(i>=j) res[i] +=  res[i - j];
			}
		}
		return res[n];
	}

}
