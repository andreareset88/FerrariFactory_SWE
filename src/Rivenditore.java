// Voglio che venga istanziato solo un rivenditore, uso il singleton pattern...

public class Rivenditore implements Observer {
	private Acquirente acq;
	private int tipoAuto;
	private int versione;
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
		catalogo.autoDisponibili();
	}
	
	// SINGLETON
	public static Rivenditore getInstance(Acquirente acq, PaymentStrategy method, Catalogo catalogo) {
		if(instance == null)
			instance = new Rivenditore(acq, method, catalogo);
		return instance;
	}

	@Override
	public void Update() {
		this.tipoAuto = acq.getTipoAuto();
		this.versione = acq.getVersione();
		createFactory();
	}
	
	private void createFactory() {
		if(versione == 0)
			factory = new StandardFactory(acq, method, catalogo);
		else if(versione == 1)
			factory = new DeluxeFactory(acq, method, catalogo);
		else System.out.println("ERROR, select 0 or 1!");
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
		//else System.out.println("ERROR, select 0, 1 or 2!");
	}

	public int getTipoAuto() {
		return tipoAuto;
	}

	public int getVersione() {
		return versione;
	}
	
	public void setMethod(int metodo) {
		if(metodo == 0)
			method = new CreditCardStrategy(acq);
		else 
			method = new TransferStrategy(acq);
	}

	
}
