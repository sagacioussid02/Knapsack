package code.practice;

public class NullCheckIfCondition {

    public static void main(String[] args) {
        String str = null;
        
        if(str!= null && str.equals("someObject")) {
            System.out.println("Checked both statements");
        } else {
            System.out.println("checked just one statement");
        }
    }

}
