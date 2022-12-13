
public abstract class Pet {
	private String name;
	private int age;
	
	public Pet(String n) {
		name = n;
		age = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void bday() {
		age++;
	}
	
	public int getAge() {
		return age;
	}
}
