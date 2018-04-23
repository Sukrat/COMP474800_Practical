
public class VehicleAllTerrain extends Vehicle {

	public VehicleAllTerrain(String model) {
		super(model);
	}

	@Override
	public double priceForRental(int daysRented) {
		double thisAmount = daysRented * 3;
		return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 1;
		if (daysRented > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
}
