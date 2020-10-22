package algorithms.companies.gs;

/**
 * Given an array of characters, compress it in-place. The length after compression must always be smaller than or equal
 * to the original array. Every element of the array should be a character (not int) of length 1. After you are done
 * modifying the input array in-place, return the new length of the array.
 * @author SS057631
 */
public class StringCompression {

    public static void main(String[] args) {
        
      System.out.println(getCompressedString("aaaaaaaaaaaaaaaaaaaaaaaa"));
      System.out.println(getCompressedString("a"));
      System.out.println(getCompressedString("abbbbbbbbbbbbbbbbb"));
      System.out.println(getCompressedString("aabbccc"));
      
        
      System.out.println(getCompressedStringModifyInputArray(new char[] {'a','a','a','a'}));
      System.out.println(getCompressedStringModifyInputArray(new char[] {'a'}));
      System.out.println(getCompressedStringModifyInputArray(new char[] {'a','b','b','b'}));
      System.out.println(getCompressedStringModifyInputArray(new char[] {'a','a','b','b','c','c','c'}));
    }
    
    private static int getCompressedString(String str) {
        if(str == null || str.length() == 1) return 1;
        int compressCount = 0;
        int j = 0; //running pointer
        int pos = 0;
        while(pos<str.length()) {
            char ch = str.charAt(pos);
            j = pos + 1;
            int count = -1;
            while(j <  str.length() && str.charAt(j) == ch) {
                count++;
                j++;
            }
            if(count == -1) {
                compressCount++;
            } else {
                compressCount += Math.floor(Math.log10(count+1) + 1) + 1; 
            }
            pos = j;
        }
        return compressCount;
    }
    
    private static int getCompressedStringModifyInputArray(char[] chars) {
        int index = 0;
        int i = 0;
        while(i<chars.length){
            int j = i;
            while(j<chars.length && chars[j] == chars[i]){
                j++;
            }
            chars[index++] = chars[i];
            if(j - i > 1){
                String count = String.valueOf(j-i);
                for(char c: count.toCharArray()){
                    chars[index++] = c;
                }
            }
            i=j;
        }
        return index; 
    }

}
