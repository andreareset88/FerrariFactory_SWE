public interface PaymentStrategy {
	public void pay(float amount) throws InterruptedException;
}
