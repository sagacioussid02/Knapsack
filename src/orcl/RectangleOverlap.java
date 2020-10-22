package orcl;

public class RectangleOverlap {
	
	//Time: O(1)
	//Space: O(1)
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]
               || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }
    
	//Time: O(1)
	//Space: O(1)
    public boolean isRectangleOverlapAnotherMethod(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }

	public static void main(String[] args) {

	}

}
