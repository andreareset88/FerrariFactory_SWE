package Strategy;

import Observer.Acquirente;
import Observer.Rivenditore;
import Strategy.PaymentStrategy;

import java.util.Scanner;

public final class CreditCardStrategy implements PaymentStrategy {
	private Acquirente acq;

	private Rivenditore riv;
	
	public CreditCardStrategy(Acquirente acq, Rivenditore riv) {
		this.acq = acq;
		this.riv = riv;
	}
	
	@Override
	public void pay(float amount) throws InterruptedException {
		int tentativiRimanenti = 3;
		boolean correct = false;
		while(!correct) {
			System.out.println("Inserire cvv per la verifica ("+tentativiRimanenti+" tentativi rimanenti)");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int code = scanner.nextInt();
			if (acq.getCvv() == code) {
				correct = true;
				System.out.println("Carta " + acq.getCardNumber() + " accettata, tentativo di pagamento in corso...");
				Thread.sleep(3000);
				float budget = acq.getBudget();
				budget -= amount;
				acq.setBudget(budget);
				riv.aggiornaProfitto(amount);
				System.out.println("Pagamento di " + amount + " €, effettuato dal Sig. " + acq.getNome() + " riuscito, il budget rimanente è di " + budget + " €");
			} else {
				System.out.println("Il codice cvv non è corretto");
				tentativiRimanenti--;
				if(tentativiRimanenti == 0){
					System.out.println("Attenzione, tentativi esauriti!");
					System.exit(0);
				}
			}
		}
	}
}