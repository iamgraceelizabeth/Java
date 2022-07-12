package pets;
/**
 * Dog is a subclass of Pet that provides more methods only
 * for those of type dog.
 * @author Grace Merry
 *
 */
public class Dog extends Pet {
	
	/**
	 * sets the default name and sound
	 */
	public Dog() {
		//sound = "woof";
		//setName("dog");
		super("dog", "woof");
	}
	
	/**
	 * sets the name and sound
	 * @param name name to set to
	 */
	public Dog(String name) {
		super(name, "woof");
	}
	
	/**
	 * sets the name and sound
	 * @param name name to set to
	 * @param sound sound to set to
	 */
	public Dog(String name, String sound) {
		super(name, sound);
	}
	
	/**
	 * displays that the dog is getting a ball
	 */
	public void fetch() {
		System.out.println(getName() + " is getting a ball...");
	}
	
	/**
	 * calls the speak() method from Pet to bark
	 */
	public void bark() {
		super.speak();
	}
	
	/**
	 * displays the sound the pet makes twice
	 */
	public void speak() {
		System.out.println(getName() + " says: " + sound + " " + sound);
	}
}
