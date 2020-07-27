package algorithms.concepts;

public class ExceptionHandling {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
           try {
               if(i %2 == 0) System.out.println("edlkdl");
               else throw new Exception();
           } catch(Exception ex) {
               System.out.println("exception");
           }
        }

    }

}
