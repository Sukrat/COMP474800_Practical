
public class VehicleCar extends Vehicle {

	public VehicleCar(String model) {
		super(model);
	}

	@Override
	public double priceForRental(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2)
			thisAmount += (daysRented - 2) * 1.5;
		return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 1;
		return frequentRenterPoints;
	}
}
