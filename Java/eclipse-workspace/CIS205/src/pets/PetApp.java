package pets;

/**
 * 
 * @author Grace Merry
 *
 */
public class PetApp {
	
	public static void main(String[] args) {
		//create a Pet object
//		Pet myPet = new Pet();
		
		//display pet name, change it and display, then display sound
//		System.out.println(myPet.getName());
//		myPet.setName("toby");
//		System.out.println(myPet.getName());
//		myPet.speak();
		
		//create another Pet object and display
		Cat myOtherPet = new Cat("babs", "meowww");
		myOtherPet.speak();
		
		//create a Dog object and use the Dog methods
		Dog myDog = new Dog();
		myDog.setName("toby");
		myDog.speak();
		myDog.fetch();
		myDog.bark();
		
		//create a new dog object and use the updated methods
		Dog myOtherDog = new Dog("rufus","wuuf");
		myOtherDog.bark();
		
	}
}
