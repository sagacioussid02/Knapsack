package code.practice;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class AnchorTime {
    
    public static void main(String[] args) {
        final GregorianCalendar currentTime = new GregorianCalendar();
        for (int i = 0; i < 15; ++i) {
            System.out.println("Current time: "+currentTime.getTimeInMillis());
            System.out.println("Tme unit in minutes: "+TimeUnit.MINUTES.toMillis(i == 0 ? 0 : 60 * (i + 1)));
            System.out.println(currentTime.getTimeInMillis()
                    - TimeUnit.MINUTES.toMillis(i == 0 ? 0 : 60 * (i + 1)));
        }
        

        
        // get minute
           Instant instant = Instant.now();
           int minute = instant.atZone(ZoneOffset.UTC).getMinute();
           System.out.println(minute);
    }

}
