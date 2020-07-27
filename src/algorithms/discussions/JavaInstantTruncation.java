package algorithms.discussions;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class JavaInstantTruncation {
    
    public static void main(String args[]) {
        Instant now = Instant.now();
        Instant truncated = now.truncatedTo(ChronoUnit.MINUTES);
        System.out.println(now);
    }

}
