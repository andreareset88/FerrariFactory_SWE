public class Catalogo {
    private int numeroLaFerrari = 0;
    private int numeroSf90Stradale = 0;
    private int numeroTestarossa = 0;

    public Catalogo(){
        numeroLaFerrari = (int)(Math.random() * 6);
        numeroSf90Stradale = (int)(Math.random() * 6);
        numeroTestarossa = (int)(Math.random() * 6);
        this.autoDisponibili();
    }

    public void autoDisponibili(){
        System.out.println("Attualmente sono disponibili: ");
        System.out.println(this.getNumeroLaFerrari()+" LaFerrari");
        System.out.println(this.getNumeroSf90Stradale()+" SF90Stradale");
        System.out.println(this.getNumeroTestarossa()+" Testarossa");
    }

    public boolean isLaFerrari(){
        if(this.getNumeroLaFerrari() > 0){
            System.out.println("LaFerrari disponibile all'acquisto!");
            return true;
        } else {
            System.out.println("LaFerrari non è attualmente disponibile...");
            return false;
        }
    }

    public boolean isSf90Stradale(){
        if(this.getNumeroSf90Stradale() > 0){
            System.out.println("SF90 Stradale disponibile all'acquisto!");
            return true;
        } else {
            System.out.println("SF90 Stradale non è attualmente disponibile...");
            return false;
        }
    }

    public boolean isTestarossa(){
        if(this.getNumeroTestarossa() > 0){
            System.out.println("Testarossa disponibile all'acquisto!");
            return true;
        } else {
            System.out.println("Testarossa non è attualmente disponibile...");
            return false;
        }
    }

    public int getNumeroLaFerrari() {
        return numeroLaFerrari;
    }

    public int getNumeroSf90Stradale() {
        return numeroSf90Stradale;
    }

    public int getNumeroTestarossa() {
        return numeroTestarossa;
    }

    public void setNumeroLaFerrari(int numeroLaFerrari) {
        this.numeroLaFerrari = numeroLaFerrari;
        System.out.println("Numero di LaFerrari impostato a "+numeroLaFerrari);
    }

    public void setNumeroSf90Stradale(int numeroSf90Stradale) {
        this.numeroSf90Stradale = numeroSf90Stradale;
        System.out.println("Numero di SF90 Stradale impostato a "+numeroSf90Stradale);
    }

    public void setNumeroTestarossa(int numeroTestarossa) {
        this.numeroTestarossa = numeroTestarossa;
        System.out.println("Numero di Testarossa impostato a "+numeroTestarossa);
    }
}
