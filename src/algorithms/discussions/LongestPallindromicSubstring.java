package algorithms.discussions;

public final class LongestPallindromicSubstring {
    
    public static int longestPallindromicSubstring(String str) {
        //validations
        if(str == null || str.length() == 0) return 0;
        if(str.length() == 1) return 1;
        
        //initialize a max variable to keep track of max
        int max = 0;
        
        //initialize a result array to find longest value can be possible using each index
        int[] res = new int[str.length()];
        res[str.length() - 1] = 0;
        res[str.length() - 2] = str.charAt(str.length() - 2) == str.charAt(str.length() - 1)? 2 : 0;
        
        //iterate over the string from the last
        for(int i = str.length() - 3; i >= 0; i--) {
            //if the next element is same then add 2
            if(str.charAt(i) == str.charAt(i + 1))
                res[i] = res[i + 1] + 2;
            //if next element is not same then check the  next to next element and add 3
            else if(str.charAt(i) != str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2))
                res[i] = res[i + 1] + 3;            
            //if next element is not same and next to next is also not same then get the value at next element
            //and check the i + value(i+1) to check whether that element is same or not
            else if(str.charAt(i) != str.charAt(i + 1) && str.charAt(res[i + 1] + 1) == str.charAt(i))
                res[i] = res[i + 1] + 2;
            else
                res[i] = 0;
            
            //update max
            max = Math.max(max, res[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPallindromicSubstring("abcbad"));
    }

}
