
public class Cat extends Animal implements Pet {
	private String name;
	
	Cat(String n){
		super(4);
		this.name=n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void play() {
		System.out.println("The Cat is playing");
	}
	
	public void eat() {
		System.out.println("The Cat is eating");
	}

}
