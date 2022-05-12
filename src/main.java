import AbstractFactory.*;
import Catalogo.*;
import Observer.*;


import java.io.IOException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws InterruptedException, IOException {

		Catalogo cat = new Catalogo();
		// Observer.Acquirente inizializzato con SF90 Stradale deluxe
		Acquirente acq = Acquirente.getInstance(1, 1, 10000000, "Charles", 789543, 997, "MN654GH");
		Rivenditore riv = Rivenditore.getInstance(acq, null, cat);
		MostraAuto gestore = new MostraAuto(riv);
		int autoVendute = 0;
		ControlloBudget.setAcq(acq);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() > 50) {
			if(cat.getNumeroSf90Stradale() > 0) {
				System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
				Scanner scanner = new Scanner(System.in);
				int metodo = scanner.nextInt();
				riv.setMethod(metodo);
				// Qui entrano in gioco Abstract Factory e Observer.Observer
				acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
				cat.setNumeroSf90Stradale(cat.getNumeroSf90Stradale() - 1);
				float polizza = acq.calcolaPolizza(1050);
				if (!acq.cancellaOrdine(polizza)) {
					autoVendute ++;
					acq.usaAuto();
					Thread.sleep(5000);
					System.out.println("Sono passati " + acq.getGiorniPassati() + " giorni e sono stati percorsi " + acq.getKmPercorsi() + " km dalla data dell'acquisto");
					if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
						riv.effettuaRevisione();
				} else {
					System.out.println(" Polizza troppo alta, ordine annullato...");
					cat.setNumeroSf90Stradale(cat.getNumeroSf90Stradale() + 1);
				}
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
		cat.autoDisponibili();
		Thread.sleep(5000);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			// AbstractFactory.LaFerrari standard
			if(cat.getNumeroLaFerrari() > 0) {
				acq.setTipoAuto(0);
				acq.setVersione(0);
				System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
				Scanner scanner2 = new Scanner(System.in);
				int metodo2 = scanner2.nextInt();
				riv.setMethod(metodo2);
				acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
				cat.setNumeroLaFerrari(cat.getNumeroLaFerrari() - 1);
				float polizza = acq.calcolaPolizza(900);
				if(!acq.cancellaOrdine(polizza)) {
					acq.usaAuto();
					autoVendute ++;
					Thread.sleep(5000);
					System.out.println("Sono passati " + acq.getGiorniPassati() + " giorni e sono stati percorsi " + acq.getKmPercorsi() + " km dalla data dell'acquisto");
					if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
						riv.effettuaRevisione();
				} else {
					System.out.println(" Polizza troppo alta, ordine annullato...");
					cat.setNumeroLaFerrari(cat.getNumeroLaFerrari() + 1);
				}
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
		cat.autoDisponibili();
		Thread.sleep(5000);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			// AbstractFactory.Testarossa deluxe
			if(cat.getNumeroTestarossa() > 0) {
				acq.setTipoAuto(2);
				acq.setVersione(1);
				System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
				Scanner scanner3 = new Scanner(System.in);
				int metodo3 = scanner3.nextInt();
				riv.setMethod(metodo3);
				acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
				cat.setNumeroTestarossa(cat.getNumeroTestarossa() - 1);
				float polizza = acq.calcolaPolizza(470);
				if(!acq.cancellaOrdine(polizza)) {
					acq.usaAuto();
					autoVendute ++;
					Thread.sleep(5000);
					System.out.println("Sono passati " + acq.getGiorniPassati() + " giorni e sono stati percorsi " + acq.getKmPercorsi() + " km dalla data dell'acquisto");
					if (acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()))
						riv.effettuaRevisione();
				}  else {
					System.out.println(" Polizza troppo alta, ordine annullato...");
					cat.setNumeroTestarossa(cat.getNumeroTestarossa() + 1);
				}
			}
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
		cat.autoDisponibili();
		acq.detach(riv);
		riv.detach(gestore);
		riv.mostraResoconto(autoVendute);
		System.exit(0);
	}
}

