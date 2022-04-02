public class TransferStrategy implements PaymentStrategy {
	//private String IBAN;
	//private String owner;
	private Acquirente acq;
	
	public TransferStrategy(Acquirente acq) {
		//this.IBAN = IBAN;
		//this.owner = owner;
		this.acq = acq;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Tentativo di pagamento tramite bonifico in corso...");
		int budget = acq.getBudget();
		budget -= amount;
		System.out.println(amount+" pagato con bonifico effettuato da "+acq.getNome()+" all'IBAN "+acq.getIBAN()+", rimangono "+budget+" €");
		acq.setBudget(budget);
	}
}
