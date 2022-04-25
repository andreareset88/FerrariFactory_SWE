public final class StandardFactory implements AbstractFactory {
	private Acquirente acq;
	private PaymentStrategy method;
	private Catalogo catalogo;
	
	public StandardFactory(Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.acq = acq;
		this.method = method;
		this.catalogo = catalogo;
	}
	@Override
	public LaFerrari createLaFerrari() {
		return new LaFerrariStandard(900, false, false, 2500000, acq, method, catalogo);
	}
	
	@Override
	public SF90Stradale createSF90Stradale() {
		return new SF90StradaleStandard(1000, false, true, 4500000, acq, method, catalogo);
	}
	
	@Override
	public Testarossa createTestarossa() {
		return new TestarossaStandard(400, false, 600000, acq, method, catalogo);
	}
}
