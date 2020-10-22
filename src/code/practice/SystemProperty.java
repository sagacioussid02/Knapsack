package code.practice;

import java.io.File;
import java.io.IOException;

public class SystemProperty {

    public static void main(String[] args) {
        System.out.println(System.getenv("TEMP"));
        String cernerJavaUserHome = System.getenv("USERNAME");
        System.setProperty("user.home", cernerJavaUserHome);
        String userHome = System.getProperty("user.home");
        try {
            File tempFile = File.createTempFile("writabilityTest", null, new File(userHome));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
