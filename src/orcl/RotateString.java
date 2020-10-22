package orcl;

public class RotateString {
	
	//Brute Force
    public static boolean rotateStringRollingHashOrRabiKarpAlgorithm(String A, String B) {
      //if you rorate the string till its length then the sequence will repeat
      //So to find out whether another string is subset you need to append
      //the same string and check if the other one is a substring
      String allRotations = A+A;
      //In brute force we used contains method which takes O(mn)
      //Here we will use Rabi Karp algorithm by rolling hashing method
      
      //calculate hash function for the second string
      int lengthOfB = B.length();
      int pow = 0;
      int hashB = 0;
      for(int i=0;i<lengthOfB;i++) {
    	  hashB += (B.charAt(i) * Math.pow(10, pow++));
      }
      
      //use fixed sliding window to find whether B contains in A
      int left = 0;
      int right = 0;
      int runningHash = 0;
      int powA = 0;
      while(left <= right && right < allRotations.length()) {
    	  runningHash += (allRotations.charAt(right++) * Math.pow(10, powA++));
    	  if((right - left + 1) == lengthOfB) {
    		  if(runningHash == hashB) {
    			  return true;
    		  }
    		  runningHash -= allRotations.charAt(left++);
    	  }
      }
      System.out.println("Hash value of STring B="+hashB);
      return A.length() == B.length() && allRotations.contains(B);
    }
	
	//Brute Force
    public static boolean rotateStringBruteForce(String A, String B) {
      //if you rotate the string till its length then the sequence will repeat
      //So to find out whether another string is subset you need to append
      //the same string and check if the other one is a substring
      String allRotations = A+A;
      return A.length() == B.length() && allRotations.contains(B);
    }
	
	//Basic Brute Force to understand
    public static boolean rotateStringBasicBruteForce(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
            for (int s = 0; s < A.length(); ++s) {
                for (int i = 0; i < A.length(); ++i) {
                    if (A.charAt((s+i) % A.length()) != B.charAt(i))
                        continue search;
                }
                return true;
            }
        return false;
    }

	public static void main(String[] args) {
		String str = "abcde";
		String str1 = "cdeab";
		rotateStringBasicBruteForce(str,str1);
	}

}
