
public abstract class Animal {
	protected int legs;
	
	protected Animal(int legs) {
		this.legs=legs;
	}
	
	public void walk() {
		System.out.println("This animal walks on " + this.legs + " legs");
	}
	
	public void eat() {
		System.out.println("The " + this.legs + "ed Animal is eating");
	}
	
	
}
