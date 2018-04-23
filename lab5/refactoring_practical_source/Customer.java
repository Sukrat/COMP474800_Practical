import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : _rentals) {
			result += "\t" + each.getVehicle().getTitle() + "\t" + String.valueOf(each.priceForRental()) + "\n";
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalRentalPrice()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

		return result;
	}

	public String htmlStatement() {
		String result = "<h1>Rental Record for " + getName() + "</h1>\n";

		result += "<ul>";
		for (Rental each : _rentals) {
			result += "<li>" + each.getVehicle().getTitle() + ": " + String.valueOf(each.priceForRental()) + "</li>\n";
		}
		result += "</ul>";

		// add footer lines
		result += "<p>Amount owed is " + String.valueOf(getTotalRentalPrice()) + "</p>\n";
		result += "<p>You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points</p>";

		return result;
	}

	private double getTotalRentalPrice() {
		double totalAmount = 0;
		for (Rental aRental : _rentals) {
			totalAmount += aRental.priceForRental();
		}
		return totalAmount;
	}

	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental aRental : _rentals) {
			frequentRenterPoints += aRental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}
}
