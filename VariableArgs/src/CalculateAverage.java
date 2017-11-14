
public class CalculateAverage {

	public static void main(String[] args) {
		
		System.out.println(getAverage(args));

	}
	
	public static float getAverage(String... numbers) {
		int sum=0;
		float average=0;
		for(String x : numbers) {
			sum+=Integer.parseInt(x);
		}
		
		average=sum/numbers.length;
		return (average);
	}

}
