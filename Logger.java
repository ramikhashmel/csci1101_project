/*
 * The logger class, which allows data to be logged at various priority levels.
 * Logging can be turned off when the program is not being debugged so that the console
 * window doesn't have unnecessary information, and looks cleaner on the demo.
 */
public class Logger {
	enum PRIORITY {
		INFO, LOW, WARN, HIGH, CRITICAL;
	}

	public static void log(String msg) {
		log(msg, PRIORITY.INFO);
	}

	public static void log(String msg, PRIORITY priority) {
		if (Utilities.isDebugging) {
			System.out.println("[" + priority.toString() + "] " + msg);
		}
	}

	public static void log(int msg, PRIORITY priority) {
		log(msg + "", priority);
	}
}
