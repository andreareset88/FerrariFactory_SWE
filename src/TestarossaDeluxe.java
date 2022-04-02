public class TestarossaDeluxe implements Testarossa {
	private int hp;
	private boolean spareWheel;
	private int price;
	private Acquirente acq;
	private PaymentStrategy method;
	
	public TestarossaDeluxe(int hp, boolean spareWheel, int price, Acquirente acq, PaymentStrategy method) {
		this.hp = hp;
		this.spareWheel = spareWheel;
		this.price = price;
		this.acq = acq;
		this.method = method;
	}
	
	private boolean checkBudget() {
		int budget = acq.getBudget();
		System.out.println("Controllo budget acquirente in corso...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(budget >= price) {
			System.out.println(acq.getNome()+" � abilitato all'acquisto!");
			return true;
		} else {
			System.out.println("ERRORE, budget troppo basso, "+acq.getNome()+" non pu� procedere all'acquisto..");
			return false;
		}
	}
	
	private void paga(PaymentStrategy paymentMethod) {
		int amount = this.getPrice();
		paymentMethod.pay(amount);
	}
	
	@Override
	public Testarossa create() {
		if(checkBudget()) {
			paga(method);
			System.out.println("Costruzione della Testarossa...");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("COSTRUZIONE COMPLETATA!");
			System.out.print("E' stata scelta la versione DELUXE, che include un motore a benzina da "+hp+" cv ");
			if(spareWheel)
				System.out.println(" e il volante in pelle.");
			System.out.println(acq.getNome()+" , l'auto Le verr� consegnata tra "+acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione())+" giorni");
			return this;
		} else {
			System.out.println("Spiacente, la costruzione non � andata a buon fine");
			return null;
		}
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
	public int getPrice() {
		return price;
	}
	public Acquirente getAcquirente() {
		return acq;
	}
}
