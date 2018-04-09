
public class OCP {
	public static void main(String[] args) {
		Square square = new Square(10.1);
		PostageStamp stamp = new PostageStamp(square);
		System.out.println(stamp.toString());

		Circle circle = new Circle(500);
		PostageStamp stampCircle = new PostageStamp(circle);
		System.out.println(stampCircle.toString());
	}
}

class PostageStamp {
	public PostageStamp(Shape shape) {
		this.shape = shape;
	}

	public String toString() {
		return "stamp, contained in a " + shape.toString();
	}

	Shape shape;
}

interface Shape {
	String toString();
}

class Square implements Shape {
	public Square(double d) {
		length = d;
	}

	public String toString() {
		return "square, side of length " + length;
	}

	private double length;
}

class Circle implements Shape {
	public Circle(double radius) {
		this.radius = radius;
	}

	public String toString() {
		return "circle, side of radius " + radius;
	}

	private double radius;
}