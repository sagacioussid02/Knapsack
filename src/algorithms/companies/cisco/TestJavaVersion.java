package algorithms.companies.cisco;

public class TestJavaVersion {

    public static void main( String[] args )
    {
        System.out.println( "JRE Version :" + System.getProperty( "java.runtime.version" ) );
        System.out.println( "JVM Bit size: " + System.getProperty( "sun.arch.data.model" ) );

    }

}
