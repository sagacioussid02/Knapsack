package code.practice;

public class Continue {
    
    public static void main(String args[]) {
        for(int i=0;i<10;i++) {
            if(i == 5) continue;
            System.out.println(i);
        }
    }
    
    private static int getSomething() {
        return 1;
    }

}
