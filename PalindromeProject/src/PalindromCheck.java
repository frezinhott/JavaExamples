
public class PalindromCheck {

	public static void main(String[] args) {
		
			System.out.println(isPalindrom("tollliot"));

	}

	public static boolean isPalindrom(String word) {
		boolean result=true;
		
		for(int i=0; i < word.length(); i++) {
			System.out.println("word.charAt(i): " + word.charAt(i));
			System.out.println("word.charAt(word.length()-i-1): " + word.charAt(word.length()-i-1));
			if(word.charAt(i) == word.charAt(word.length()-i-1)) {
				result=true;
			}
			else {
				result=false;
				break;
			}		
			
		}
		return result;
	}

}
