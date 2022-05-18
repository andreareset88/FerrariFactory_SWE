import AbstractFactory.*;
import Catalogo.*;
import Observer.*;
import Strategy.*;
import org.junit.*;

import static org.junit.Assert.*;

public class SF90StradaleStandardTest {
    private static Acquirente acq;
    private static Catalogo cat;
    private static Rivenditore riv;
    private static SF90StradaleStandard sf90standard;

    @BeforeClass
    public static void initialize() {
        acq = Acquirente.getInstance(1,0,4500000, "Charles", 654321, 554, "MNG654HJ");
        ControlloBudget.setAcq(acq);
        cat = new Catalogo();
        riv = Rivenditore.getInstance(acq, null, cat);
        sf90standard = new SF90StradaleStandard(1000, false, false, 4500000, acq, new TransferStrategy(acq, riv), cat);
    }

    @Test
    public void creaSF90StandardTest() throws InterruptedException {
        cat.setNumeroSf90Stradale(3);
        assertNotNull("Oggetto non creato correttamente", sf90standard.create());
    }
    // Il test deve stabilire che non verrà creato l'oggetto anche se è disponibile, a causa del budget basso
    @Test
    public void budgetBassoTest() throws InterruptedException {
        acq.setBudget(4499999);
        assertNull("Oggetto creato anche se budget troppo basso", sf90standard.create());
    }

    @AfterClass
    public static void deallocate() {
        acq = null;
        cat = null;
        riv = null;
        sf90standard = null;
    }
}