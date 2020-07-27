package algorithms.discussions;

import java.util.Stack;

public class SimpllifyPath {

    public static String simplifyPath(String path) {

        if (path == null)
            return "/";
        if (path.length() == 1 && path.charAt(0) == '/')
            return path;
        if (path.length() == 1 && path.charAt(0) != '/')
            return "/" + path;

        // initialize a stack and iterate through the string
        Stack<Character> canonicalStack = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            // if / appears then peek the stack
            if (ch == '/') {
                if (count > 0) {
                    count++;
                    while (count > 0 && !canonicalStack.isEmpty()) {
                        char popped = canonicalStack.pop();
                        if (popped == '/')
                            count--;
                    }
                    count = 0;
                }
                if (!canonicalStack.isEmpty() && canonicalStack.peek() != '/') {
                    if (i != path.length() - 1)
                        canonicalStack.push('/');
                } else if(canonicalStack.isEmpty()) canonicalStack.push('/');
            } else {
                canonicalStack.push(ch);
                if (ch == '.') {
                    count++;
                }
                   
            }
            
            if(count > 0 && i == path.length() - 1) {
                count++;
                while (count > 0 && !canonicalStack.isEmpty()) {
                    char popped = canonicalStack.pop();
                    if (popped == '/')
                        count--;
                }
                canonicalStack.push('/');
            }

        }
        
        //reverse a stack
        String reversedStackString = reverseStackRecursion(canonicalStack);
        
        StringBuilder str = new StringBuilder();
        while(!canonicalStack.isEmpty()) str.append(canonicalStack.pop());
        return str.reverse().toString();
    }
    
    public static String reverseStackRecursion(Stack<Character> inputStack) {
        if(inputStack.isEmpty()) return "";
        char pop = inputStack.pop();
        return reverseStackRecursion(inputStack) + pop;
    }

    public static void main(String[] args) {
        /*
         * System.out.println(simplifyPath("/home/")); System.out.println(simplifyPath("/home/./"));
         * System.out.println(simplifyPath("/home/././")); System.out.println(simplifyPath("/home//foo/../"));
         */
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/home//foo////bar/etc//././/../abc"));
    }

}
