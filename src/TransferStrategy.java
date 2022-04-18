public class TransferStrategy implements PaymentStrategy {
	private Acquirente acq;

	private Rivenditore riv;
	
	public TransferStrategy(Acquirente acq, Rivenditore riv) {
		this.acq = acq;
		this.riv = riv;
	}

	@Override
	public void pay(float amount) throws InterruptedException {
		System.out.println("Tentativo di pagamento tramite bonifico in corso...");
		float budget = acq.getBudget();
		budget -= amount;
		Thread.sleep(3000);
		acq.setBudget(budget);
		riv.aggiornaProfitto(amount);
		System.out.println(amount+" pagato con bonifico effettuato da "+acq.getNome()+" all'IBAN "+acq.getIBAN()+", rimangono "+budget+" €");
	}
}
