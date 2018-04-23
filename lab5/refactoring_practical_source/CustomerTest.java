
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCustomer() {
		Customer c = new CustomerBuilder().build();
		assertNotNull(c);
	}

	@Test
	public void testGetName() {
		Customer c = new Customer("Sean");
		assertEquals("Sean", c.getName());
	}

	@Test
	public void statementForCar() {
		Vehicle vehicle1 = new VehicleCar("Peugeot 207");
		Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
		Customer customer2 = new CustomerBuilder().withName("Aoife").withRentals(rental1).build();
		String expected = "Rental Record for Aoife\n" + "\tPeugeot 207\t3.5\n" + "Amount owed is 3.5\n"
				+ "You earned 1 frequent renter points";
		String statement = customer2.statement();
		assertEquals(expected, statement);
	}

	@Test
	public void statementForAllTerrainVehicle() {
		Vehicle vehicle1 = new VehicleAllTerrain("Landrover Freelander");
		Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
		Customer customer2 = new CustomerBuilder().withName("Aoife").withRentals(rental1).build();
		String expected = "Rental Record for Aoife\n" + "\tLandrover Freelander\t9.0\n" + "Amount owed is 9.0\n"
				+ "You earned 2 frequent renter points";
		String statement = customer2.statement();
		assertEquals(expected, statement);
	}

	@Test
	public void statementForMotorbike() {
		Vehicle vehicle1 = new VehicleMotorBike("Honda 50");
		Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
		Customer customer2 = new CustomerBuilder().withName("Aoife").withRentals(rental1).build();
		String expected = "Rental Record for Aoife\n" + "\tHonda 50\t1.5\n" + "Amount owed is 1.5\n"
				+ "You earned 1 frequent renter points";
		String statement = customer2.statement();
		assertEquals(expected, statement);
	}

	@Test
	public void statementForManyRentals() {
		Vehicle vehicle1 = new VehicleMotorBike("Honda 50");
		Rental rental1 = new Rental(vehicle1, 6); // 6 day rental
		Vehicle vehicle2 = new VehicleAllTerrain("Landrover Freelander");
		Rental rental2 = new Rental(vehicle2, 2); // 2 day rental
		Vehicle vehicle3 = new VehicleCar("Peugeot 207");
		Rental rental3 = new Rental(vehicle3, 8); // 8 day rental
		Customer customer1 = new CustomerBuilder().withName("Sean").withRentals(rental1, rental2, rental3).build();
		String expected = "Rental Record for Sean\n" + "\tHonda 50\t6.0\n" + "\tLandrover Freelander\t6.0\n"
				+ "\tPeugeot 207\t11.0\n" + "Amount owed is 23.0\n" + "You earned 4 frequent renter points";
		String statement = customer1.statement();
		assertEquals(expected, statement);
	}

	//TODO make test for price breaks in code.
	@Test
	public void htmlStatementForManyRentals() {
		Vehicle vehicle1 = new VehicleMotorBike("Honda 50");
		Rental rental1 = new Rental(vehicle1, 6); // 6 day rental
		Vehicle vehicle2 = new VehicleAllTerrain("Landrover Freelander");
		Rental rental2 = new Rental(vehicle2, 2); // 2 day rental
		Vehicle vehicle3 = new VehicleCar("Peugeot 207");
		Rental rental3 = new Rental(vehicle3, 8); // 8 day rental
		Customer customer1 = new CustomerBuilder().withName("Sean").withRentals(rental1, rental2, rental3).build();
		String expected = "<h1>Rental Record for Sean</h1>\n" + "<ul><li>Honda 50: 6.0</li>\n"
				+ "<li>Landrover Freelander: 6.0</li>\n" + "<li>Peugeot 207: 11.0</li>\n"
				+ "</ul><p>Amount owed is 23.0</p>\n" + "<p>You earned 4 frequent renter points</p>";
		String statement = customer1.htmlStatement();
		assertEquals(expected, statement);
	}
}

class CustomerBuilder {

	public Customer build() {
		Customer result = new Customer(name);
		for (Rental rental : rentals) {
			result.addRental(rental);
		}
		return result;
	}

	public CustomerBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CustomerBuilder withRentals(Rental... rentals) {
		Collections.addAll(this.rentals, rentals);
		return this;
	}

	private String name = "default";
	private List<Rental> rentals = new ArrayList<Rental>();
}