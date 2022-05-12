import AbstractFactory.ControlloBudget;
import AbstractFactory.TestarossaDeluxe;
import Catalogo.Catalogo;
import Observer.Acquirente;
import Observer.Rivenditore;
import Strategy.TransferStrategy;
import org.junit.*;

import static org.junit.Assert.*;

public class TestarossaDeluxeTest {

    private static Acquirente acq;
    private static Catalogo cat;
    private static Rivenditore riv;
    private static TestarossaDeluxe testarossa;

    @BeforeClass
    public static void initialize(){
        acq = Acquirente.getInstance(2,1,4000000, "Charles", 987654, 332, "MN678GH");
        ControlloBudget.setAcq(acq);
        cat = new Catalogo();
        riv = Rivenditore.getInstance(acq, null, cat);
        testarossa = new TestarossaDeluxe(470, true, 800000, acq, new TransferStrategy(acq, riv), cat);
    }

    @Test
    public void creaTestarossaDeluxeTest() throws InterruptedException {
        cat.setNumeroTestarossa(4);
        assertNotNull("Oggetto non creato correttamente", testarossa.create());
    }

    @Test
    public void budgetTroppoBassoTest() throws InterruptedException {
        acq.setBudget(500000);
        assertNull("Oggetto creato anche se budget troppo basso", testarossa.create());
    }

    @AfterClass
    public static void deallocate() {
        acq = null;
        cat = null;
        riv = null;
        testarossa = null;
    }
}