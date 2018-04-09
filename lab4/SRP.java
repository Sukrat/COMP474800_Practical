
public class SRP {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

class Hexapod {

	private Man _man;

	private Dog _dog;

	private String _name;

	public Hexapod(String name) {
		_name = name;
		_man = new Man(name);
		_dog = new Dog(name);
	}

	public void throwStick() {
		_man.throwStick();
	}

	public void fetchStick() {
		_dog.fetchStick();
	}

	public void walk() {
		_man.walk();
		_dog.walk();
	}

	public void bark() {
		_dog.bark();
	}
}

class Man {
	private String _name;

	public Man(String name) {
		this._name = name;
	}

	public void throwStick() {
		ystem.out.println(_name + " is throwing a stick");
	}

	public void walk() {
		System.out.println(_name + " walking");
	}
}

class Dog {

	String _name;

	public Dog(String name) {
		_name = name;
	}

	public void fetchStick() {
		System.out.println(_name + " fetching a stick");
	}

	public void walk() {
		System.out.println(_name + " walking");
	}

	public void bark() {
		System.out.println(_name + " Woof!");
	}
}