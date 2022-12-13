
public class Parrot extends Pet{
	private String favoritePhrase;
	
	public Parrot(String phrase, String name) {
		super(name);
		favoritePhrase = phrase;
	}
	
	
	public void makeSound() {
		System.out.println(favoritePhrase);
	}
}
