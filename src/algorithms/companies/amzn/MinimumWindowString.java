package algorithms.companies.amzn;

public class MinimumWindowString {
	
	public static void main(String[] args) {
		System.out.println(getMinimumWindow("pqrbefadcba", "abcd"));
	}
	
	public static int getMinimumWindow(String str1, String str2) {
		if(str1 == null || str2 == null) return 0;
		if(str1.length() < str2.length()) return 0;
		
		int min = str1.length();
		int left = 0;
		int right = 0;
		boolean[] visited = new boolean[str2.length()];
		
		while(left <= right && right < str1.length()) {
			while(!isAllCharacterVisited(visited)) {
				int indexOfRightChar = str2.indexOf(str1.charAt(right));
				if(indexOfRightChar > -1) visited[indexOfRightChar] = true;
				right++;
			}
			
			while(isAllCharacterVisited(visited)) {
				int indexOfLeftChar = str2.indexOf(str1.charAt(left));
				if(indexOfLeftChar > -1) visited[indexOfLeftChar] = false;
				left++;
			}
			
			min = Math.min(min, right - left + 1);
		}
		return min;
	}
	
	public static boolean isAllCharacterVisited(boolean[] visited) {
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}

}
