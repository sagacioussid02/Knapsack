package algorithms.gayle.arrays;

public class MyObjectToTestCallByValue {
    
    int id;
    String name;
    
    
    public MyObjectToTestCallByValue(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "MyObjectToTestCallByValue [id=" + id + ", name=" + name + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    

}
