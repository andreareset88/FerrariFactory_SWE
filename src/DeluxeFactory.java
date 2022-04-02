public class DeluxeFactory implements AbstractFactory {
	private Acquirente acq;
	private PaymentStrategy method;
	
	public DeluxeFactory(Acquirente acq, PaymentStrategy method) {
		this.acq = acq;
		this.method = method;
	}
	@Override
	public LaFerrari createLaFerrari() {
		return new LaFerrariDeluxe(963, true, true, 3000000, acq, method);
	}
	
	@Override
	public SF90Stradale createSF90Stradale() {
		return new SF90StradaleDeluxe(1050, true, true, 5000000, acq, method);
	}
	
	@Override
	public Testarossa createTestarossa() {
		return new TestarossaDeluxe(470, true, 800000, acq, method);
	}
}

