
public abstract class Vehicle {

	private String _model;

	public Vehicle(String model) {
		_model = model;
	}

	public String getTitle() {
		return _model;
	}

	public abstract double priceForRental(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);
}
