public final class LaFerrariDeluxe implements LaFerrari {
	private int hp;
	private boolean satNav;
	private boolean leatherWheel;
	private int price;
	private Acquirente acq;
	private PaymentStrategy method;
	private Catalogo catalogo;
	
	public LaFerrariDeluxe(int hp, boolean satNav, boolean leatherWheel, int price, Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.hp = hp;
		this.satNav = satNav;
		this.leatherWheel = leatherWheel;
		this.price = price;
		this.acq = acq;
		this.method = method;
		this.catalogo = catalogo;
	}
	
	private boolean checkBudget() {
		int budget = acq.getBudget();
		System.out.println("Controllo budget acquirente in corso...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(budget >= this.getPrice()) {
			System.out.println(acq.getNome()+" è abilitato all'acquisto!");
			return true;
		} else {
			System.out.println("ERRORE, budget troppo basso, "+acq.getNome()+" non può procedere all'acquisto..");
			return false;
		}
	}
	
	public void paga(PaymentStrategy paymentMethod) throws InterruptedException {
		int amount = this.getPrice();
		paymentMethod.pay(amount);
	}
	
	@Override
	public LaFerrari create() throws InterruptedException {
		if(catalogo.isLaFerrari()) {
			if (checkBudget()) {
				paga(method);
				System.out.println("E' in corso l'invio dell'ordine alla fabbrica per la LaFerrari...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("INVIO EFFETTUATO!");
				System.out.println("E' stata scelta la versione DELUXE, che include un motore ibrido da " + hp + " cv");
				if (satNav)
					System.out.print(" , il sistema di navigazione");
				if (leatherWheel)
					System.out.println(" , il volante in pelle");
				int giorni = acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione());
				System.out.println(acq.getNome() + " , l'auto Le verrà consegnata tra " + giorni + " giorni");
				return this;
			} else {
				System.out.println("Spiacenti, l'invio non è andato a buon fine");
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
