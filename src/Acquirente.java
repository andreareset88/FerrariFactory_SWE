import java.io.IOException;

public final class Acquirente extends Subject {
	private int tipoAuto;
	private int versione;
	private float budget;
	private String nome;
	private int cardNumber;
	private int cvv;
	private String IBAN;
	private int indiceGradimento = 0;
	private int kmPercorsi = 0;
	private int giorniPassati = 0;
	private static Acquirente instance = null;
	
	
	private Acquirente(int tipoAuto, int versione, float budget, String nome, int cardNumber, int cvv, String IBAN) {
		this.tipoAuto = tipoAuto;
		this.versione = versione;
		this.budget = budget;
		this.nome = nome;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.IBAN = IBAN;
	}

	// SINGLETON
	public static Acquirente getInstance(int tipoAuto, int versione, float budget, String nome, int cardNumber, int cvv, String IBAN){
		if(instance == null)
			instance = new Acquirente(tipoAuto, versione, budget, nome, cardNumber, cvv, IBAN);
		return instance;
	}
	
	public void scegliMacchina(int tipo, int versione) throws InterruptedException, IOException {
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
			else return lf + 16;
		}
		if(tipo == 1) {
			if(version == 0)
				return sf;
			else return sf + 20;
		}
		if(version == 0)
			return tr;
		return tr + 23;
	}

	public float calcolaPolizza(int cv){
		float assicurazione  = 0;
		float superBollo = 0;
		if(cv >= 0 && cv < 700){
			assicurazione = 8000;
			superBollo = 9000;
		} if(cv >= 700 && cv < 1000){
			assicurazione = 10000;
			superBollo = 11000;
		} else if(cv >= 1000){
			assicurazione = 11500;
			superBollo = 12000;
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

	// Se il costo della polizza supera il 40% del budget, annulla l'ordine
	public boolean cancellaOrdine(float polizza){
		float perc = (polizza * 100) / (this.getBudget());
		System.out.println("La polizza annua rappresenta il "+perc+" % del budget");
		return perc >= 40;
	}

	public int getTipoAuto() {
		return tipoAuto;
	}

	public int getVersione() {
		return versione;
	}

	public float getBudget() {
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

	public void setBudget(float budget) {
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
