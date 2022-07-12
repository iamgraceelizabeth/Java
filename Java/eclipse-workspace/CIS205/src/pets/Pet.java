package pets;

/**
 * Pet allows you to create a Pet Object where you can set the name and sound
 * if you choose, change the name, retrieve the name, and display the name and sound.
 * @author Grace Merry
 *
 */
public abstract class Pet {
	//define the variables
	private static String DEF_SOUND = "???";
	private static String DEF_NAME = "pet";
	private String name;
	protected String sound;
	
	/**
	 * sets the default name and sound
	 */
	public Pet() {
		name = DEF_NAME;
		sound = DEF_SOUND;
	}
	
	/**
	 * sets the name and sound
	 * @param name pets name to set
	 */
	public Pet(String name) {
		this.name = name;
		sound = DEF_SOUND;
	}
	
	/**
	 * sets the name and sound
	 * @param name pet's name
	 * @param sound pets's sound
	 */
	public Pet(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	/**
	 * sets the pet's name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the pet's name
	 * @return the pet's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * displays the sound the pet makes
	 */
	public void speak() {
		System.out.println(name + " says: " + sound);
	}
}
