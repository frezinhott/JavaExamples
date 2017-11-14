
public class SingletonTest {

	public static void main(String[] args) {
		Singleton singleton1;
		Singleton singleton2;
		
		singleton1 = new Singleton();
		singleton2 = new Singleton();
		
		singleton1 = Singleton.getInstance();
		singleton2 = Singleton.getInstance();
		
		if(singleton1==singleton2)
			System.out.println("Both singletons are the same instance");

	}

}
