package orcl;

public class PowXN {
	
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        
        return recursionHelper(x, n);
    }
    
    public double recursionHelper(double x, int n){
        if(n==0){
            return 1.0;
        }
        double halfPower = recursionHelper(x, n/2);
        if(n % 2 == 0){
            return halfPower * halfPower;
        } else{
           return halfPower * halfPower * x; 
        } 
    }

}
