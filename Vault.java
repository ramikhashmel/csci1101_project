// TODO: make the vault values more realistic and remember to update them
// when money is withdrawn

public class Vault {
	private static int fives = 10;
	private static int tens = 10;
	private static int twenties = 10;
	private static int fifties = 10;
	
	public static int getFifties() {
		return fifties;
	}

	public static int getFives() {
		return fives;
	}

	public static int getTens() {
		return tens;
	}

	public static int getTotal() {
		return (getFives() + getTens() + getTwenties() + getFifties());
	}

	public static int getTwenties() {
		return twenties;
	}

	public void setFifties(int fifties) {
		Vault.fifties = fifties;
	}

	public void setFives(int fives) {
		Vault.fives = fives;
	}

	public void setTens(int tens) {
		Vault.tens = tens;
	}

	public void setTwenties(int twenties) {
		Vault.twenties = twenties;
	}
}
