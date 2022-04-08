public class TestarossaStandard implements Testarossa {
	private int hp;
	private boolean spareWheel;
	private int price;
	private Acquirente acq;
	private PaymentStrategy method;
	private Catalogo catalogo;
	
	public TestarossaStandard(int hp, boolean spareWheel, int price, Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.hp = hp;
		this.spareWheel = spareWheel;
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
		if(budget >= price) {
			System.out.println(acq.getNome()+" è abilitato all'acquisto!");
			return true;
		} else {
			System.out.println("ERRORE, budget troppo basso, "+acq.getNome()+" non pu� procedere all'acquisto..");
			return false;
		}
	}
	
	private void paga(PaymentStrategy paymentMethod) throws InterruptedException {
		int amount = this.getPrice();
		paymentMethod.pay(amount);
	}
	
	@Override
	public Testarossa create() throws InterruptedException {
		if(catalogo.isTestarossa()) {
			if (checkBudget()) {
				paga(method);
				System.out.println("Invio dell'ordine alla fabbrica per la Testarossa...");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("INVIO COMPLETATO!");
				System.out.print("E' stata scelta la versione BASE, che include un motore a benzina da " + hp + " cv");
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
	public int getPrice() {
		return price;
	}
	public Acquirente getAcquirente() {
		return acq;
	}
	
}
