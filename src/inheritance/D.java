package inheritance;

public class D implements A{

    @Override
    public void getMessage() {
        System.out.println("A is called");
    }
    
    public class E implements B{

        @Override
        public void getMessage() {
            System.out.println("From E - > B is called");
        }
        
    }

}
