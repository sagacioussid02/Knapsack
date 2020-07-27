package homework;

public class MinimumStepsToOne {
    
    public static int minimumStepsToOne(int num) {
        if(num <= 1) return 0;
        if(num == 2 || num == 3) return 1;
        int count = 0;
        int[] res = new int[num+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        res[3] = 1;
        for(int i=4;i<num;i++){
            if(i % 3 == 0) {
                res[i] = Math.min(res[i - 1], res[i/3]) + 1;
                System.out.println(res[i]);
            }
            else if(i % 2 == 0){
                        res[i] = Math.min(res[i - 1], res[i/2]) + 1;
                        System.out.println(res[i]);
            } 
            else{
                res[i] = res[i-1] + 1;
                System.out.println(res[i]);
            } 
        }
        return res[num];
    }

    public static void main(String[] args) {
        minimumStepsToOne(5);
    }

}
