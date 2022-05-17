package AbstractFactory;

import AbstractFactory.LaFerrari;
import Catalogo.*;
import Observer.*;
import Strategy.*;

public final class LaFerrariDeluxe implements LaFerrari {
	private final int hp;
	private final boolean satNav;
	private final boolean leatherWheel;
	private final float price;
	private final Acquirente acq;
	private PaymentStrategy method;
	private final Catalogo catalogo;

	
	public LaFerrariDeluxe(int hp, boolean satNav, boolean leatherWheel, float price, Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.hp = hp;
		this.satNav = satNav;
		this.leatherWheel = leatherWheel;
		this.price = price;
		this.acq = acq;
		this.method = method;
		this.catalogo = catalogo;
	}

	
	public void paga(PaymentStrategy paymentMethod) throws InterruptedException {
		float amount = this.getPrice();
		paymentMethod.pay(amount);
	}
	
	@Override
	public LaFerrari create() throws InterruptedException {
		if(catalogo.isLaFerrari()) {
			if (ControlloBudget.checkBudget(this.getPrice())) {
				paga(method);
				System.out.println("E' in corso l'invio dell'ordine alla fabbrica per la AbstractFactory.LaFerrari...");
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
	public float getPrice() {
		return price;
	}
	public Acquirente getAcquirente() {
		return acq;
	}
}
