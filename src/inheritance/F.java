package inheritance;

public class F implements A.B{

    @Override
    public void getMessage() {
        System.out.println("From F to B");
    }

}
