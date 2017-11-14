
public class TestArrays {

	public static void main(String[] args) {
		int[] array1={
			2, 3, 5, 7, 11, 13, 17, 19
		};
		
		int[] array2;
		
		printArray(array1);
		
		// array2 and array1 now reference array1
		array2=array1;
		
		// Update the even elements of array2 to the indexed value
		for(int i=0; i<array2.length; i++) {
			if(i%2==0 || i==0) {
				array2[i]=i;
			}
		}
		
		printArray(array1);

	}
	
	public static void printArray(int[] inputArray) {
		String outputString="<";
		for(int i=0; i<inputArray.length; i++) {
			outputString+=inputArray[i];
			
			if(i==inputArray.length-1)
				outputString+=">";
			else
				outputString+=",";
			
		}	
		System.out.println(outputString);
	}

}
