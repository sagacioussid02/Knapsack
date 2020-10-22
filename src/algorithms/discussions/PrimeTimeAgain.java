package algorithms.discussions;

public class PrimeTimeAgain {

    public static void main(String[] args) {
        int D=49;
        int P=7;
        
        int numOfHours = getNumberOfHoursInEachPart(D, P);
        System.out.println(getPrimeEquivalentNumber(D,P));
    }
    
    public static int getPrimeEquivalentNumber(int D, int P) {
        int numOfHours = getNumberOfHoursInEachPart(D, P);
        if(Math.floor(numOfHours)!=numOfHours) return 0;
        int res=0;
        for(int i=1;i<=numOfHours;i++) {       
            int part=0;
            int count=0;
            while(part < P) {
                int num = (part * numOfHours) + i;
                if(!isPrime(num)) break;
                part++;
                count++;
            }
            if(count==P) {
                res++;
            }
            
        }
        
        return res;
        
    }
    
   public static int getNumberOfHoursInEachPart(int D, int P) {
       return D/P;
   }
    
    
    public static boolean isPrime(int n) {
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true;
    }

}
