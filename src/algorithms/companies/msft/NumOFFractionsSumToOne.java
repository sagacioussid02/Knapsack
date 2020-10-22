package algorithms.companies.msft;

import java.util.HashSet;
import java.util.Set;

public class NumOFFractionsSumToOne {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,4};
        int[] denoms = new int[] {2,2,6};
        
        System.out.println(fractionSumIsEqualToOne(nums,denoms));

    }
    
    public static int fractionSumIsEqualToOne(int[] num, int[] denom) {
        final Set<Fraction> values = new HashSet<Fraction>();
        int count = 0;
        for(int i=0;i<num.length;i++) {
            int numerator = num[i];
            int denominator = denom[i];
            Fraction simplifiedFraction = getSimplifiedFraction(numerator, denominator);
            int numeratorOfSumToFind = simplifiedFraction.getDenom() - simplifiedFraction.getNum();
            int denomOfSumTOFind = simplifiedFraction.getDenom();
            Fraction simplifiedFractionToFind = getSimplifiedFraction(numeratorOfSumToFind, denomOfSumTOFind);
            if(values.contains(simplifiedFractionToFind)) {
                count++;
            } else {
                values.add(simplifiedFraction);
            }
            
        }
        
        return count;
    }
    
    public static boolean ifSumOfTwoFractionsIsOne(int num, int denom) {
        return false;
    }
    
    public static int calculateGCD(int num, int denom) {
        //to find gcd divide both of them till the largest divisor
        //which is always less than or equal the smallest number
        int smallerNumber = num > denom ? denom : num;
        int gcd = -1;
        for(int i=2;i<smallerNumber;i++) {
            if((Math.floor((double)num/i) == Math.ceil((double)num/i)) && (Math.floor((double)denom/i) == Math.ceil((double)denom/i))) {
                gcd = i;
            }
        }
        return gcd == -1 ? 1 : gcd;
    }
    
    public static Fraction getSimplifiedFraction(int num, int denom) {
        int gcd = calculateGCD(num, denom);
        return new Fraction(num/gcd, denom/gcd);
    }

}

class Fraction {
    int num;
    int denom;
    
    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }
    
    

    public int getNum() {
        return num;
    }



    public void setNum(int num) {
        this.num = num;
    }



    public int getDenom() {
        return denom;
    }



    public void setDenom(int denom) {
        this.denom = denom;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + denom;
        result = prime * result + num;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fraction other = (Fraction) obj;
        if (denom != other.denom)
            return false;
        if (num != other.num)
            return false;
        return true;
    }
}
