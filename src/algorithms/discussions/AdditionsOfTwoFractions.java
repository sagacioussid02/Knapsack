package algorithms.discussions;

public class AdditionsOfTwoFractions {

    public static void main(String[] args) {

    }
    
    private static int[] addTwoFractions(int[] f1,int[] f2) {
        int a = f1[0];
        int b = f1[1];
        
        int c = f2[0];
        int d = f2[1];
        
        int numerator = (a * d) + (b * c);
        int denom = (b * d);
        return new int[] {numerator, denom};
    }
    
    public static int gcd(int num1, int num2) {
        int t;
        while (num2 != 0) {
        t = num2;
        num2 = num1 % num2;
        num1 = t;
        }
          
        return num1;
    }

}
