public class ControlloBudget {
    private static Acquirente acq;

    public static boolean checkBudget(float price){
        float budget = acq.getBudget();
        System.out.println("Controllo budget acquirente in corso...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(budget >= price){
            System.out.println(acq.getNome()+" è abilitato all'acquisto!");
            return true;
        } else {
            System.out.println("ERRORE, budget troppo basso, "+acq.getNome()+" non può procedere all'acquisto..");
            return false;
        }
    }

    public static void setAcq(Acquirente acq) {
        ControlloBudget.acq = acq;
    }
}
