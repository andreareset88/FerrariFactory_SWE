import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws InterruptedException {

		Catalogo cat = new Catalogo();
		Acquirente acq = Acquirente.getInstance(1, 1, 15000000, "Charles", 789543, 997, "MN654GH");
		Rivenditore riv = Rivenditore.getInstance(acq, null, cat);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
			Scanner scanner = new Scanner(System.in);
			int metodo = scanner.nextInt();
			riv.setMethod(metodo);
			acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
			acq.calcolaPolizza(1050);
		} else System.out.println(acq.getNome()+" non è interessato all'acuisto della vettura scelta.");
		Thread.sleep(5000);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			acq.setTipoAuto(0);
			acq.setVersione(0);
			System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
			Scanner scanner2 = new Scanner(System.in);
			int metodo2 = scanner2.nextInt();
			riv.setMethod(metodo2);
			acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
			acq.calcolaPolizza(900);
		} else System.out.println(acq.getNome()+" non è interessato all'acquisto della vettura scelta.");
		Thread.sleep(5000);
		riv.pubblicizza();
		if(acq.getIndiceGradimento() >= 50) {
			acq.setTipoAuto(2);
			acq.setVersione(1);
			System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
			Scanner scanner3 = new Scanner(System.in);
			int metodo3 = scanner3.nextInt();
			riv.setMethod(metodo3);
			acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
			acq.calcolaPolizza(470);
		}
	}
}

