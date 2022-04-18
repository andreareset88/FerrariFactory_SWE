import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws InterruptedException {

		Catalogo cat = new Catalogo();
		// Acquirente inizializzato con SF90 Stradale deluxe
		Acquirente acq = Acquirente.getInstance(1, 1, 7500000, "Charles", 789543, 997, "MN654GH");
		Rivenditore riv = Rivenditore.getInstance(acq, null, cat);
		ControlloBudget.setAcq(acq);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() > 50) {
			System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
			Scanner scanner = new Scanner(System.in);
			int metodo = scanner.nextInt();
			riv.setMethod(metodo);
			// Qui entrano in gioco Abstract Factory e Observer
			acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
			if(cat.getNumeroSf90Stradale() > 0) {
				cat.setNumeroSf90Stradale(cat.getNumeroSf90Stradale() - 1);
				float polizza = acq.calcolaPolizza(1050);
				if (!acq.cancellaOrdine(polizza)) {
					acq.usaAuto();
					Thread.sleep(5000);
					System.out.println("Sono passati " + acq.getGiorniPassati() + " giorni e sono stati percorsi " + acq.getKmPercorsi() + " km dalla data dell'acquisto");
					if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
						riv.effettuaRevisione();
					cat.autoDisponibili();
				} else System.out.println(" Polizza troppo alta, ordine annullato...");
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
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
				cat.setNumeroLaFerrari(cat.getNumeroLaFerrari() - 1);
				float polizza = acq.calcolaPolizza(900);
				if(!acq.cancellaOrdine(polizza)) {
					acq.usaAuto();
					Thread.sleep(5000);
					System.out.println("Sono passati " + acq.getGiorniPassati() + " giorni e sono stati percorsi " + acq.getKmPercorsi() + " km dalla data dell'acquisto");
					if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
						riv.effettuaRevisione();
					cat.autoDisponibili();
				} else System.out.println(" Polizza troppo alta, ordine annullato...");
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
				cat.setNumeroTestarossa(cat.getNumeroTestarossa() - 1);
				float polizza = acq.calcolaPolizza(470);
				if(!acq.cancellaOrdine(polizza)) {
					acq.usaAuto();
					Thread.sleep(5000);
					System.out.println("Sono passati " + acq.getGiorniPassati() + " giorni e sono stati percorsi " + acq.getKmPercorsi() + " km dalla data dell'acquisto");
					if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
						riv.effettuaRevisione();
					cat.autoDisponibili();
				}  else System.out.println(" Polizza troppo alta, ordine annullato...");
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
		acq.Detach(riv);
	}
}

