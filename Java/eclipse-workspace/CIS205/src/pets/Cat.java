package pets;

public class Cat extends Pet {
	
	/**
	 * sets the default name and sound
	 */
	public Cat() {
		//sound = "woof";
		//setName("dog");
		super("cat", "meow");
	}
	
	/**
	 * sets the name and sound
	 * @param name name to set to
	 */
	public Cat(String name) {
		super(name, "meow");
	}
	
	/**
	 * sets the name and sound
	 * @param name name to set to
	 * @param sound sound to set to
	 */
	public Cat(String name, String sound) {
		super(name, sound);
	}
	
	/**
	 * displays that the cat is ignoring me
	 */
	public void fetch() {
		System.out.println(getName() + " ignores me...");
	}
	
}
