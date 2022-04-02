import java.util.Scanner;

public class CreditCardStrategy implements PaymentStrategy {
	private Acquirente acq;
	// private int cardNumber;
	// private Date dateOfExpiry;
	// private int cvv;
	
	public CreditCardStrategy(Acquirente acq) {
		this.acq = acq;
		// this.cardNumber = cardNumber;
		// this.dateOfExpiry = dateOfExpiry;
		// this.cvv = cvv;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println("Inserire cvv per la verifica");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int code = scanner.nextInt();
		if(acq.getCvv() == code) {
			System.out.println("Carta "+acq.getCardNumber()+" accettata, tentativo di pagamento in corso...");
			int budget = acq.getBudget();
			budget -= amount;
			System.out.println("Pagamento di "+amount+" �, effettuato dal Sig. "+acq.getNome()+" riuscito, il budget rimanente � di "+budget+" �");
			acq.setBudget(budget);
		}
		else
			System.out.println("Il codice cvv non � corretto");
	}
}