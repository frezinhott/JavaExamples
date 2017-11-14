
public class Fish extends Animal implements Pet{
	private String name;
	
	Fish(){
		super(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void play() {
		System.out.println("This Fish is playing");
	}
	
	public void walk() {
		System.out.println("The Fish is swimming");
	}

	public void eat() {
		System.out.println("The Fish is eating");
	}
}
