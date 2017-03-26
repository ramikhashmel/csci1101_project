import java.util.Random;

// this is for the view class as well
public abstract class Utilities {
	static Random rand = new Random();
	public static final boolean isDebugging = true;
	public static final String ATMName = "Brand New ATM";

	static public String genRandCCNumber() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 16; i++) {
			sb.append(randNumber(0, 9));
		}
		return sb.toString();
	}

	static public int randNumber(int min, int max) {
		return rand.nextInt(max) + min;
	}
}