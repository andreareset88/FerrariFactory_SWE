public class main {
	
	public static void main(String[] args) {
		/*System.out.println("Inserire nome");
		Scanner scanner8 = new Scanner(System.in);
		String nome = scanner8.nextLine();
		System.out.println("Inserire budget per il cliente");
		Scanner scanner = new Scanner(System.in);
		int budget = scanner.nextInt();
		System.out.println("Scegliere il tipo di Ferrari scelta (0 per LaFerrari, 1 per SF90 Stradale, 2 per Testarossa");
		Scanner scanner2 = new Scanner(System.in);
		int tipo = scanner2.nextInt();
		System.out.println("Scegliere la versione (0 per quella standard, 1 per quella deluxe");
		Scanner scanner3 = new Scanner(System.in);
		int versione = scanner3.nextInt();
		System.out.println("Scegliere il metodo di pagamento (0 per carta di credito, 1 per bonifico");
		Scanner scanner4 = new Scanner(System.in);
		int metodo = scanner4.nextInt();
		System.out.println("Inserire numero carta di credito");
		Scanner scanner5 = new Scanner(System.in);
		int carta = scanner5.nextInt();
		System.out.println("cvv:");
		Scanner scanner6 = new Scanner(System.in);
		int cvv = scanner6.nextInt();
		System.out.println("Inserire IBAN per il pagamento tramite bonifico");
		Scanner scanner7 = new Scanner(System.in);
		String iban = scanner7.nextLine();
		Acquirente acq = new Acquirente(tipo, versione, budget, nome, carta, cvv, iban);
		Rivenditore riv = Rivenditore.getInstance(acq, null);
		riv.setMethod(metodo);
		acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());*/
		Acquirente acq = new Acquirente(1, 1, 65000000, "Charles", 9876543, 334, "MN765RT");
		Rivenditore riv = Rivenditore.getInstance(acq, null);
		riv.setMethod((int)(Math.random() * 2));
		acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
		acq.setTipoAuto(0);
		acq.setVersione(0);
		acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
		acq.setTipoAuto(2);
		acq.setVersione(1);
		acq.scegliMacchina(acq.getTipoAuto(), acq.getVersione());
	}
}

