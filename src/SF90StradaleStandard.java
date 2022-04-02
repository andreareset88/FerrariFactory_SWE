public class SF90StradaleStandard implements SF90Stradale {
	private int hp;
	private boolean satNav = false;
	private boolean leatherWheel = false;
	private int price;
	private Acquirente acq;
	private PaymentStrategy method;
	
	public SF90StradaleStandard(int hp, boolean satNav, boolean leatherWheel, int price, Acquirente acq, PaymentStrategy method) {
		this.hp = hp;
		this.satNav = satNav;
		this.leatherWheel = leatherWheel;
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
			System.out.println(acq.getNome()+" è abilitato all'acquisto!");
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
	public SF90Stradale create() {
		if(checkBudget()) {
			paga(method);
			System.out.println("Costruzione della SF90 Stradale...");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("COSTRUZIONE COMPLETATA!");
			System.out.print("E' stata scelta la versione BASE, che include un motore ibrido da  "+hp+" cv");
			System.out.println(acq.getNome()+" , l'auto Le verrà consegnata tra "+acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione())+" giorni");
			return this;
		} else {
			System.out.println("Spiacente, la costruzione non è andata a buon fine");
			return null;
		}
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
	public int getPrice() {
		return price;
	}
	public Acquirente getAcquirente() {
		return acq;
	}
}
