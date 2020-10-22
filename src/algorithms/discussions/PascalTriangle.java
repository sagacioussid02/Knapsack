package algorithms.discussions;

public class PascalTriangle {

    public static void main(String[] args) {
        Assert.equals(cellValue(0,0), 1);
        Assert.equals(cellValue(2,4), 6);
        Assert.equals(cellValue(3,2), -1);
        Assert.equals(cellValue(10,50), 1682343578);
        Assert.equals(cellValue(50,60), -1);
    }
    
    public static int cellValue(int Col, int Row) {
        if(Row < Col || Row < 0 || Col < 0) return -1;
        if(Row > Integer.MAX_VALUE || Col > Integer.MAX_VALUE) return -1;
        
        int[][] res = new int[Row + 1][Row + 1];
        
        for(int i=0;i<res.length;i++) {
            for(int j=0;j<res[0].length;j++) {
                if(j==0 || i==j) res[i][j] = 1;
                else if(i > 0 && j > 0) {
                    res[i][j] = res[i-1][j] + res[i-1][j-1];
                    if(res[i][j]  < 0) return -1; //for overflow case, if integer is more than max_value, negative number will be stored coz of 2s complement
                }
            }
        }
        
        return res[Row][Col];
    }

}

class Assert{
    public static void equals(int actual, int expected){
        if(actual == expected) System.out.println("PASSED");
        else System.out.println("FAILED");
    }
}
