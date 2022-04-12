import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws InterruptedException {

		Catalogo cat = new Catalogo();
		// Acquirente inizializzato con SF90 Stradale deluxe
		Acquirente acq = Acquirente.getInstance(1, 1, 15000000, "Charles", 789543, 997, "MN654GH");
		Rivenditore riv = Rivenditore.getInstance(acq, null, cat);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
			Scanner scanner = new Scanner(System.in);
			int metodo = scanner.nextInt();
			riv.setMethod(metodo);
			acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
			if(cat.getNumeroSf90Stradale() > 0) {
				acq.calcolaPolizza(1050);
				acq.usaAuto();
				if(acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
					riv.effettuaRevisione();
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acuisto della vettura scelta.");
		Thread.sleep(5000);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			// LaFerrari standard
			acq.setTipoAuto(0);
			acq.setVersione(0);
			System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
			Scanner scanner2 = new Scanner(System.in);
			int metodo2 = scanner2.nextInt();
			riv.setMethod(metodo2);
			acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
			if(cat.getNumeroLaFerrari() > 0) {
				acq.calcolaPolizza(900);
				acq.usaAuto();
				if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
					riv.effettuaRevisione();
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
		Thread.sleep(5000);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			// Testarossa deluxe
			acq.setTipoAuto(2);
			acq.setVersione(1);
			System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
			Scanner scanner3 = new Scanner(System.in);
			int metodo3 = scanner3.nextInt();
			riv.setMethod(metodo3);
			acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
			if(cat.getNumeroTestarossa() > 0) {
				acq.calcolaPolizza(470);
				acq.usaAuto();
				if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
					riv.effettuaRevisione();
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
	}
}

