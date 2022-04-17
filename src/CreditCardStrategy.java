import java.util.Scanner;

public class CreditCardStrategy implements PaymentStrategy {
	private Acquirente acq;
	
	public CreditCardStrategy(Acquirente acq) {
		this.acq = acq;
	}
	
	@Override
	public void pay(float amount) throws InterruptedException {
		System.out.println("Inserire cvv per la verifica");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int code = scanner.nextInt();
		if(acq.getCvv() == code) {
			System.out.println("Carta "+acq.getCardNumber()+" accettata, tentativo di pagamento in corso...");
			Thread.sleep(3000);
			float budget = acq.getBudget();
			budget -= amount;
			System.out.println("Pagamento di "+amount+" €, effettuato dal Sig. "+acq.getNome()+" riuscito, il budget rimanente è di "+budget+" €");
			acq.setBudget(budget);
		}
		else
			System.out.println("Il codice cvv non è corretto"); // TODO migliora controllo cvv
	}
}