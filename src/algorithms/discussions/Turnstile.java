package algorithms.discussions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Turnstile {

	public static void main(String[] args) {
		int[] arrTime = new int[] {0,0,1,5};
		int[] dir = new int[] {0,1,1,0};
		Arrays.stream(getTimes(4,arrTime, dir)).forEach(System.out::println);
	}

	public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
		PriorityQueue<TurnStileEntity> qu = new PriorityQueue<TurnStileEntity>((e1, e2) -> {
			if(e1.time == e2.time) {
				return (e1.index - e2.index);
			} else {
				return (e1.time - e2.time);
			}
		});
		
		for(int i=0;i<arrTime.length;i++) {
			qu.offer(new TurnStileEntity(i, direction[i], arrTime[i]));
		}
		
		int prevDirection = -1;
		int[] result = new int[numCustomers];
		
		while(qu.size() > 1) {
			TurnStileEntity first = qu.poll();
			TurnStileEntity second = qu.poll();
			
			if(first.time == second.time) {
				switch(prevDirection) {
				case -1:
					if(first.dir==1) {
						result[first.index] = first.time;
						second.time++;
						qu.offer(second);
						
					} else if(second.dir==1) {
						result[second.index] = second.time;
						first.time++;
						qu.offer(first);
					}
					prevDirection = 1;
					break;
				case 1:
					if(first.dir==1) {
						result[first.index] = first.time;
						second.time++;
						qu.offer(second);
					} else if(second.dir==1) {
						result[second.index] = second.time;
						first.time++;
						qu.offer(first);
					}
					prevDirection = 1;
					break;
				case 0:
					if(first.dir==0) {
						result[first.index] = first.time;
						second.time++;
						qu.offer(second);
					} else if(second.dir==0) {
						result[second.index] = second.time;
						first.time++;
						qu.offer(first);
					}
					prevDirection = 0;
					break;
				}
			} else {
				prevDirection = first.dir;
				result[first.index] = first.time;
				qu.offer(second);
			}
		}
		
		if(!qu.isEmpty()) {
			TurnStileEntity lastEntity = qu.poll();
			result[lastEntity.index] = lastEntity.time;
		}
		
		return result;
	}
}

class TurnStileEntity{
	int index;
	int dir;
	int time;
	
	public TurnStileEntity(int index, int dir, int time) {
		this.index = index;
		this.dir = dir;
		this.time = time;
	}
}
