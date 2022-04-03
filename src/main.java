import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {

		int numeroLaFerrari = (int)(Math.random() * 6);
		int numeroSf90Stradale = (int)(Math.random() * 6);
		int numeroTestarossa = (int)(Math.random() * 6);
		Catalogo cat = new Catalogo(numeroLaFerrari, numeroSf90Stradale, numeroTestarossa);
		Acquirente acq = new Acquirente(1, 1, 65000000, "Charles", 9876543, 334, "MN765RT");
		Rivenditore riv = Rivenditore.getInstance(acq, null, cat);
		System.out.println("Scegliere metodo di pagamento (0 per carta di credito, 1 per bonifico)");
		Scanner scanner = new Scanner(System.in);
		int metodo = scanner.nextInt();
		riv.setMethod(metodo);
		acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
		acq.setTipoAuto(0);
		acq.setVersione(0);
		acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
		acq.setTipoAuto(2);
		acq.setVersione(1);
		acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
	}
}

