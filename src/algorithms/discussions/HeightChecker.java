package algorithms.discussions;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo. Return the minimum number of
 * students that must move in order for all students to be standing in non-decreasing order of height. Notice that when
 * a group of students is selected they can reorder in any possible way between themselves and the non selected students
 * remain on their seats.
 * Leetcode 1051.1
 * @author SS057631
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        // counting sort direct application
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }

        int j = 0;
        int result = 0;
        for (int height : heights) {

            // check the next populated element in the count array
            // we should consider only the elelments which was populated
            // in the first pass
            while (count[j] <= 0) {
                j++;
            }

            // if the index and the value in the main array is same
            // that means that value is in correct position and need not
            // to be moved
            if (height != j)
                result++;

            // everytime one value is checked, we should decrement the values in
            // count array to move to next populated element
            count[j]--;

        }
        return result;

    }

}
