public interface PaymentStrategy {
	void pay(float amount) throws InterruptedException;
}
