
// Represents a rental of a vehicle
public class Rental {

	private Vehicle _vehicle;
	private int _daysRented;

	public Rental(Vehicle vehicle, int daysRented) {
		_vehicle = vehicle;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Vehicle getVehicle() {
		return _vehicle;
	}

	double priceForRental() {
		return _vehicle.priceForRental(_daysRented);
	}

	public int getFrequentRenterPoints() {
		return _vehicle.getFrequentRenterPoints(_daysRented);
	}
}
