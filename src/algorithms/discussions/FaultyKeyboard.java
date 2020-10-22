package algorithms.discussions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FaultyKeyboard {

    public static void main(String[] args) {
        String type = "experience was ultimate";
        String clip = "ew";
        FaultyKeyboard keyBoard = new FaultyKeyboard();
        Integer result = keyBoard.getNumberOfOps(type, clip);
        System.out.println(result);

    }

    public static int getNumberOfOps(String str, String clipBoardString) {
        Set<Character> clipBoardUniqueChars = clipBoardString.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
        int count=0;
        List<Integer> indices = getIndices(str, clipBoardString);
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(!indices.contains(i) && checkIfOneCharacterPresentInOther(ch,clipBoardUniqueChars)) {
                count += getOperations(ch, clipBoardString);
            }
            
            if(indices.contains(i)) i+=clipBoardString.length();
        }
        return count + indices.size();
        
    }

    public static int getOperations(char ch, String clipBoard) {
        int indexOfch = clipBoard.indexOf(ch);
        if (indexOfch == 0)
            return clipBoard.length();
        if (indexOfch == clipBoard.length() - 1)
            return indexOfch + 3;
        int countBeforeNumber = indexOfch + 2;
        int countAfterNumber = clipBoard.length() - indexOfch - 1;
        return countBeforeNumber + countAfterNumber + 1;

    }

    public static boolean checkIfOneCharacterPresentInOther(char ch, Set<Character> clipboardChars) {
        return clipboardChars.contains(ch);
    }

    public static List<Integer> getIndices(String str, String s) {
        List<Integer> indices = new ArrayList<Integer>();
        boolean flag = false;
        for (int i = 0; i < str.length() - s.length() + 1; i++) {
            if (str.substring(i, i + s.length()).equals(s)) {
                indices.add(i);
                flag = true;
            }
        }
        return indices;
    }
}
