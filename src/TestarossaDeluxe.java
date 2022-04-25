public final class TestarossaDeluxe implements Testarossa {
	private int hp;
	private boolean spareWheel;
	private float price;
	private Acquirente acq;
	private PaymentStrategy method;
	private Catalogo catalogo;
	
	public TestarossaDeluxe(int hp, boolean spareWheel, float price, Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.hp = hp;
		this.spareWheel = spareWheel;
		this.price = price;
		this.acq = acq;
		this.method = method;
		this.catalogo = catalogo;
	}

	
	private void paga(PaymentStrategy paymentMethod) throws InterruptedException {
		float amount = this.getPrice();
		paymentMethod.pay(amount);
	}
	
	@Override
	public Testarossa create() throws InterruptedException {
		if(catalogo.isTestarossa()) {
			if (ControlloBudget.checkBudget(this.getPrice())) {
				paga(method);
				System.out.println("Invio dell'ordine alla fabbrica per la Testarossa...");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("INVIO COMPLETATO!");
				System.out.print("E' stata scelta la versione DELUXE, che include un motore a benzina da " + hp + " cv ");
				if (spareWheel)
					System.out.println(" e il volante in pelle.");
				System.out.println(acq.getNome() + " , l'auto Le verrà consegnata tra " + acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione()) + " giorni");
				return this;
			} else {
				System.out.println("Siamo spiacenti, l'invio non è andato a buon fine");
				return null;
			}
		} else return null;
	}
	
	public int getHp() {
		return hp;
	}
	public boolean isSpareWheel() {
		return spareWheel;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setSpareWheel(boolean spareWheel) {
		this.spareWheel = spareWheel;
	}
	public float getPrice() {
		return price;
	}
	public Acquirente getAcquirente() {
		return acq;
	}
}
