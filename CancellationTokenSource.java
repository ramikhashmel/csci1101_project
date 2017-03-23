
public class CancellationTokenSource {
	private boolean isCancelled = false;
	
	public void cancel() {
		this.isCancelled = true;
	}
	
	public boolean isCancelled() {
		return this.isCancelled;
	}
}
