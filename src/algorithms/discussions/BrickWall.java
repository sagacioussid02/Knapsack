package algorithms.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * There is a brick wall in front of you. The wall is rectangular and has
 * several rows of bricks. The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the
 * least bricks.
 * 
 * The brick wall is represented by a list of rows. Each row is a list of
 * integers representing the width of each brick in this row from left to right.
 * 
 * If your line go through the edge of a brick, then the brick is not considered
 * as crossed. You need to find out how to draw the line to cross the least
 * bricks and return the number of crossed bricks.
 * 
 * You cannot draw a line just along one of the two vertical edges of the wall,
 * in which case the line will obviously cross no bricks.
 * 
 * @author SS057631
 *
 */
public class BrickWall {

	public static int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> closingAtIndex = new HashMap<>();
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				if (closingAtIndex.containsKey(sum)) {
					closingAtIndex.put(sum, closingAtIndex.get(sum) + 1);
				} else {
					closingAtIndex.put(sum, 1);
				}
			}
		}
		int res = wall.size();
		for (int key : closingAtIndex.keySet())
			res = Math.min(res, wall.size() - closingAtIndex.get(key));
		return res;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> brickList = new ArrayList<List<Integer>>();
		brickList = Arrays.asList(Arrays.asList(1,2,2,1), Arrays.asList(3,1,2), Arrays.asList(1,3,2),Arrays.asList(2,4), Arrays.asList(3,1,2), Arrays.asList(1,3,1,1));
		leastBricks(brickList);
	}
	

}
