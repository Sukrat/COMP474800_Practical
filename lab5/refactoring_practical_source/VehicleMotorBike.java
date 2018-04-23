
public class VehicleMotorBike extends Vehicle {

	public VehicleMotorBike(String model) {
		super(model);
	}

	@Override
	public double priceForRental(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 1;
		return frequentRenterPoints;
	}
}
