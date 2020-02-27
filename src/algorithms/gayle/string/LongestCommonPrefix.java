package algorithms.gayle.string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"apple","app","app","appl"}));
	}
	
	
	public static String longestCommonPrefix(String[] words) {
		if(words == null) return "";
		if(words.length == 1) return words[0];
		
		int pointer = 0;
		StringBuilder res = new StringBuilder();
		for(char c : words[0].toCharArray()) {
			for(int i = 1; i < words.length; i++) {
				if(words[i].length() <= pointer)  return res.toString();
				else if(c != words[i].charAt(pointer)) return res.toString();
			}
			res.append(c);
			pointer++;
		}
		return res.toString();
	}

}
