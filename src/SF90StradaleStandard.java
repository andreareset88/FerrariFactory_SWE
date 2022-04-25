public final class SF90StradaleStandard implements SF90Stradale {
	private int hp;
	private boolean satNav = false;
	private boolean leatherWheel = false;
	private float price;
	private Acquirente acq;
	private PaymentStrategy method;
	private Catalogo catalogo;
	
	public SF90StradaleStandard(int hp, boolean satNav, boolean leatherWheel, float price, Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.hp = hp;
		this.satNav = satNav;
		this.leatherWheel = leatherWheel;
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
	public SF90Stradale create() throws InterruptedException {
		if(catalogo.isSf90Stradale()) {
			if (ControlloBudget.checkBudget(this.getPrice())) {
				paga(method);
				System.out.println("Invio dell'ordine alla fabbrica per la SF90 Stradale in corso...");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("INVIO COMPLETATO!");
				System.out.print("E' stata scelta la versione BASE, che include un motore ibrido da  " + hp + " cv");
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
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setSatNav(boolean satNav) {
		this.satNav = satNav;
	}
	public void setLeatherWheel(boolean leatherWheel) {
		this.leatherWheel = leatherWheel;
	}
	public float getPrice() {
		return price;
	}
	public Acquirente getAcquirente() {
		return acq;
	}
}
