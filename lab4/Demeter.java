
public class Demeter {
	static final String CURRENCY_SYMBOL = "Euro";

	public static void main(String[] args) {
		ShopKeeper john = new ShopKeeper();
		Wallet wallet = new Wallet(95);
		System.out.println("Initial value in wallet is: " + CURRENCY_SYMBOL + wallet.getTotalMoney());
		Customer aoife = new Customer(wallet);
		john.chargeCustomer(aoife, 50);
		System.out.println("Value in wallet after purchase is: " + CURRENCY_SYMBOL + wallet.getTotalMoney());
	}
}

class Customer {
	public Customer(Wallet wallet) {
		name = ""; //unused
		myWallet = wallet;
	}

	public String getName() {
		return name;
	}

	public Wallet getWallet() {
		return myWallet;
	}

	public boolean hasEnoughAmount(float amount) {
		return myWallet.getTotalMoney() > amount;
	}

	public void spend(float amount) {
		myWallet.subtractMoney(amount);
	}

	private String name;
	private Wallet myWallet;
}

class Wallet {
	public Wallet(float newValue) {
		value = newValue;
	}

	public float getTotalMoney() {
		return value;
	}

	public void addMoney(float deposit) {
		value += deposit;
	}

	public void subtractMoney(float debit) {
		value -= debit;
	}

	private float value;
}

class ShopKeeper {
	// ...
	public void chargeCustomer(Customer cust, float amount) {
		if (cust.hasEnoughAmount(amount)) {
			cust.spend(amount);
		} else {
			// get the baseball bat...
		}

	}
	// ...
}