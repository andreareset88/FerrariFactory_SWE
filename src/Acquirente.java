public class Acquirente extends Subject {
	private int tipoAuto;
	private int versione;
	private int budget;
	private String nome;
	private int cardNumber;
	private int cvv;
	private String IBAN;
	private int indiceGradimento = 0;
	private int kmPercorsi = 0;
	private int giorniPassati = 0;
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
	
	public void scegliMacchina(int tipo, int versione) throws InterruptedException {
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

	public float calcolaPolizza(int cv){
		float assicurazione  = 0;
		float superBollo = 0;
		if(cv >= 400 && cv < 700){
			assicurazione = 6500;
			superBollo = 7000;
		} if(cv >= 700 && cv < 1000){
			assicurazione = 7500;
			superBollo = 8000;
		} else if(cv >= 1000){
			assicurazione = 9000;
			superBollo = 10000;
		}
		float totaleAnnuo = assicurazione + superBollo;
		System.out.println("Costo annuo: assicurazione = "+assicurazione+" €, super bollo = "+superBollo+" €, per un totale di "+totaleAnnuo+" €");
		System.out.println("Costo mensile: assicurazione = "+assicurazione/12+" €, super bollo = "+superBollo/12+" €, per un totale di "+totaleAnnuo/12+" €/mese");
		return totaleAnnuo;
	}

	public boolean checkRevisione(int giorniPassati, int kmPercorsi) throws InterruptedException {
		if(giorniPassati >= 1095 || kmPercorsi >= 20000){
			System.out.println("E' necessario portare la vettura in officina per la revisione");
			return true;
		} else {
			System.out.println("Non è ancora il momento per la revisione");
			return false;
		}
	}

	public void usaAuto(){
		int giorni = (int)(Math.random() * 2001);
		this.setGiorniPassati(giorni);
		int km = (int)(Math.random() * 40001);
		this.setKmPercorsi(km);
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

	public void updateIndiceGradimento(int indiceGradimento) {
		this.indiceGradimento = indiceGradimento;
	}

	public int getKmPercorsi() {
		return kmPercorsi;
	}

	public void setKmPercorsi(int kmPercorsi) {
		this.kmPercorsi = kmPercorsi;
	}

	public int getGiorniPassati() {
		return giorniPassati;
	}

	public void setGiorniPassati(int giorniPassati) {
		this.giorniPassati = giorniPassati;
	}

}
