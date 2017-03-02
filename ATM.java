import java.util.Scanner;

public class ATM {
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		String pin = askUserForInput("Enter in PIN: ");
	}
	
	public static String askUserForInput(String msg) {
		System.out.print(msg);
		return kb.nextLine();
	}
	public static float askUserForFloat(String msg) {
		System.out.print(msg);
		return kb.nextFloat();
	}
}
