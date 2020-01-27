package pramp;

public class ValidateIp {

	public static void main(String[] args) {
		System.out.println(validateIP("008.168.008.1"));
	}
	
	static boolean validateIP(String ip) {
		// your code goes here
    
    if(ip.length()==0 || ip==null) return false;
    String arr[] = ip.split("\\.");
    int value=0;
    if(arr.length!=4)
      return false;
    
    for(String each : arr) {
    	try {
    		int n = Integer.parseInt(each);
    		if(n<0 || n>255) return false;
    	}catch(NumberFormatException ex) {
    		return false;
    	}
    }
    return true;
	}
}
