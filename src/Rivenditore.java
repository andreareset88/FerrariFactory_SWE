// Voglio che venga istanziato solo un rivenditore, uso il singleton pattern...

public class Rivenditore implements Observer {
	private Acquirente acq;
	private int tipoAuto;
	private int versione;
	private float profitto = 0;
	private AbstractFactory factory;
	private LaFerrari laferrari;
	private SF90Stradale sf90stradale;
	private Testarossa testarossa;
	private PaymentStrategy method;
	private Catalogo catalogo;
	private static Rivenditore instance = null;
	
	private Rivenditore(Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		this.acq = acq;
		this.acq.Attach(this);
		this.method = method;
		this.catalogo = catalogo;
	}
	
	// SINGLETON
	public static Rivenditore getInstance(Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		if(instance == null)
			instance = new Rivenditore(acq, method, catalogo);
		return instance;
	}

	@Override
	public void Update() throws InterruptedException {
		this.tipoAuto = acq.getTipoAuto();
		this.versione = acq.getVersione();
		createFactory();
	}
	
	private void createFactory() throws InterruptedException {
		if(versione == 0)
			factory = new StandardFactory(acq, method, catalogo);
		else if(versione == 1)
			factory = new DeluxeFactory(acq, method, catalogo);
		if(tipoAuto == 0) {
			laferrari = factory.createLaFerrari();
			laferrari.create();
		}
		if(tipoAuto == 1) {
			sf90stradale = factory.createSF90Stradale();
			sf90stradale.create();
		}
		if(tipoAuto == 2) {
			testarossa = factory.createTestarossa();
			testarossa.create();
		}
	}

	public void pubblicizza() throws InterruptedException {
		System.out.println("SPOT PUBBLICITARIO IN TRASMISSIONE...");
		acq.updateIndiceGradimento((int)(Math.random() * 101));
		Thread.sleep(5000);
		System.out.println("SPOT TERMINATO");
	}

	public void effettuaRevisione() throws InterruptedException {
		System.out.println("Revisione in corso...");
		Thread.sleep(10000);
		acq.setGiorniPassati(0);
		acq.setKmPercorsi(0);
		System.out.println("Revisione completata!");
	}

	public int getTipoAuto() {
		return tipoAuto;
	}

	public int getVersione() {
		return versione;
	}

	public void aggiornaProfitto(float euro){
		float guadagno = this.getProfitto();
		guadagno += euro;
		this.setProfitto(guadagno);
	}

	public void setProfitto(float profitto){
		this.profitto = profitto;
	}
	public float getProfitto(){
		return profitto;
	}
	public void setMethod(int metodo) {
		if(metodo == 0)
			method = new CreditCardStrategy(acq, this);
		else 
			method = new TransferStrategy(acq, this);
	}

	public void mostraResoconto(int autoVendute){
		System.out.println("RIEPILOGO DELL'AFFARE CON IL SIG."+acq.getNome()+" :");
		System.out.print("Numero di auto vendute: "+autoVendute);
		System.out.print(", guadagno totale: "+this.getProfitto()+" €.");
	}
}
