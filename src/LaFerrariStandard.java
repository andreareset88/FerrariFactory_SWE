public final class LaFerrariStandard implements LaFerrari{
	private int hp;
	private boolean satNav = false;
	private boolean leatherWheel = false;
	private int price;
	private Acquirente acq;
	private PaymentStrategy method;
	private Catalogo catalogo;
	
	public LaFerrariStandard(int hp, boolean satNav, boolean leatherWheel, int price, Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.hp = hp;
		this.satNav = satNav;
		this.leatherWheel = leatherWheel;
		this.price = price;
		this.acq = acq;
		this.method = method;
		this.catalogo = catalogo;
	}
	
	private void paga(PaymentStrategy paymentMethod) throws InterruptedException {
		int amount = this.getPrice();
		paymentMethod.pay(amount);
	}

	
	@Override
	public LaFerrari create() throws InterruptedException {
		if(catalogo.isLaFerrari()) {
			if (ControlloBudget.checkBudget(this.getPrice())) {
				paga(method);
				System.out.println("E' in corso l'invio dell'ordine alla fabbrica per la LaFerrari...");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("INVIO COMPLETATO!");
				System.out.println("E' stata scelta la versione BASE, che comprende un motore Ferrari a benzina da " + hp + " cv");
				if (satNav)
					System.out.print(" , il sistema di navigazione");
				if (leatherWheel)
					System.out.print(" , un volante in pelle");
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
	
	public boolean isSatNav() {
		return satNav;
	}
	
	
	public boolean isLeatherWheel() {
		return leatherWheel;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Acquirente getAcquirente() {
		return acq;
	}
}
