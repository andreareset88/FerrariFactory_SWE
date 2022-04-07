public class Acquirente extends Subject {
	private int tipoAuto;
	private int versione;
	private int budget;
	private String nome;
	private int cardNumber;
	private int cvv;
	private String IBAN;
	private int indiceGradimento = 0;
	private static Acquirente instance = null;
	
	
	public Acquirente(int tipoAuto, int versione, int budget, String nome, int cardNumber, int cvv, String IBAN) {
		this.tipoAuto = tipoAuto;
		this.versione = versione;
		this.budget = budget;
		this.nome = nome;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.IBAN = IBAN;
	}

	// SINGLETON
	public static Acquirente getInstance(int tipoAuto, int versione, int budget, String nome, int cardNumber, int cvv, String IBAN){
		if(instance == null)
			instance = new Acquirente(tipoAuto, versione, budget, nome, cardNumber, cvv, IBAN);
		return instance;
	}
	
	public void scegliMacchina(int tipo, int versione) {
		tipoAuto = tipo;
		this.versione = versione;
		Notify();
	}
	
	public int calcolaAttesa(int tipo, int version) {
		int lf = 60;
		int sf = 75;
		int tr = 100;
		if(tipo == 0) {
			if(version == 0)
				return lf;
			else return lf+(int)(Math.random()*31);
		}
		if(tipo == 1) {
			if(version == 0)
				return sf;
			else return sf+(int)(Math.random()*31);
		}
		if(version == 0)
			return tr;
		return tr+(int)(Math.random()*31);
	}

	public int getTipoAuto() {
		return tipoAuto;
	}

	public int getVersione() {
		return versione;
	}

	public int getBudget() {
		return budget;
	}

	public String getNome() {
		return nome;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setTipoAuto(int tipoAuto) {
		this.tipoAuto = tipoAuto;
	}

	public void setVersione(int versione) {
		this.versione = versione;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public int getIndiceGradimento() {
		return indiceGradimento;
	}

	public void updateIndiceGradimento(int update) {
		indiceGradimento += update;
	}
}
