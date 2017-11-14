public class TestIsSubString {
    
    /*
     * Write a isSubString method that searches for a specific string within
     * another string; the method must return true if the former exists in the
     * latter string. Otherwise, the method return false.
     */
        
    
    public static void main(String[] args) {
        String text = "The cat in the hat.";
        
        System.out.println("isSubString(\"cat\", \"The cat in the hat.\") "
                + isSubString("cat", text));
        
        System.out.println("isSubString(\"bat\", \"The cat in the hat.\") "
                + isSubString("bat", text));
        
        System.out.println("isSubString(\"The\", \"The cat in the hat.\") "
                + isSubString("The", text));
        
        System.out.println("isSubString(\"hat.\", \"The cat in the hat.\") "
                + isSubString("hat.", text));
        
    }
    
    public static boolean isSubString(String subString, String fullString) {
    	boolean result=false;
    	
    	// Loop through the full string
    	for(int i=0; i < fullString.length(); i++) {
    		
    		if (fullString.charAt(i)==subString.charAt(0)) {
    			
    			// Loop through the subString
    			for(int j=0; j < subString.length(); j++) {
    				if (fullString.charAt(i)==subString.charAt(j)) {
    					result = true;
    				}
    				else {
    					result = false;
    					break;
    				}
    				i++;
    			}
    		}
    	}
    	return result;
    }
}