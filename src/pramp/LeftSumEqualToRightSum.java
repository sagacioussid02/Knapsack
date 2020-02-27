package pramp;

import java.util.ArrayList;
import java.util.List;

public class LeftSumEqualToRightSum {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(4);
		list.add(1);
		list.add(2);
		System.out.println(pivotIndex(list));
	}
	
    public static int pivotIndex(List<Integer> numbers) {
        //get thre total sum of the numbers in list
        int size = numbers.size();
        int totalSum = 0;
        for(int i=0;i<size;i++){
            totalSum += numbers.get(i);
        }

        int leftSum = 0;
        int rightSum = totalSum - numbers.get(0);
        //check each index one by one using a sliding window
        for(int i=1;i<size;i++){
            leftSum += numbers.get(i-1);
            rightSum = rightSum - numbers.get(i);
            if(leftSum == rightSum) return i;
        }
        return -1;
    }

}
