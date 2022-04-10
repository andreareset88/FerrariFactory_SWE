public class TransferStrategy implements PaymentStrategy {
	private Acquirente acq;
	
	public TransferStrategy(Acquirente acq) {
		this.acq = acq;
	}

	@Override
	public void pay(int amount) throws InterruptedException {
		System.out.println("Tentativo di pagamento tramite bonifico in corso...");
		int budget = acq.getBudget();
		budget -= amount;
		Thread.sleep(3000);
		System.out.println(amount+" pagato con bonifico effettuato da "+acq.getNome()+" all'IBAN "+acq.getIBAN()+", rimangono "+budget+" €");
		acq.setBudget(budget);
	}
}
