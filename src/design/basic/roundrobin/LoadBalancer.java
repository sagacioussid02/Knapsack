package design.basic.roundrobin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.plaf.SliderUI;

public class LoadBalancer {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread 1 is running...");
				loadBalance("1st thread");
				
			}
		});
		
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread 2 is running...");
				loadBalance("2nd thread");
			}
		});
		executorService.shutdown();
	}

	private static void loadBalance(String threadName) {
		System.out.println("Thread :"+threadName);
		doGetServer(new RoundRobin(), threadName);
	}

	private static void doGetServer(RoundRobin roundRobin, String threadName) {
		doGetServer(roundRobin, 5, threadName);
	}

	private static void doGetServer(RoundRobin roundRobin, int queryTimes, String threadName) {
        for (int i = 1; i <= queryTimes; i++) {
            String serverId = roundRobin.getServer(String.valueOf(i));
            System.out.println(String.format("[%s] index:%s,%s", roundRobin.getClass().getSimpleName(), i, serverId)+"thread :"+threadName);
            if(i % 3 == 0 && threadName.equals("1st thread")) {
            	System.out.println("Removing a server");
            	IPpool.removeServer("192.168.1.2");
            }
            if(i % 2 == 0 && threadName.equals("2st thread")) {
            	System.out.println("Adding a server");
            	IPpool.removeServer("192.168.1.2");
            }
        }
	}

}
