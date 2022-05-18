import AbstractFactory.*;
import Catalogo.*;
import Observer.*;
import Strategy.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LaFerrariDeluxeTest {
    private static Acquirente acq;
    private static Catalogo cat;
    private static Rivenditore riv;
    private static LaFerrariDeluxe laferrari;

    @BeforeClass
    public static void initialize() {
        acq = Acquirente.getInstance(0,1,6000000, "Charles", 98765, 889, "MN789GH");
        ControlloBudget.setAcq(acq);
        cat = new Catalogo();
        riv = Rivenditore.getInstance(acq, null, cat);
        laferrari = new LaFerrariDeluxe(963, true, true, 3000000, acq, new TransferStrategy(acq, riv), cat);
    }

    @Test
    public void creaLaFerrariDeluxeTest() throws InterruptedException {
        cat.setNumeroLaFerrari(1);
        assertNotNull("LaFerrari Deluxe non creata", laferrari.create());
    }

    @Test
    public void nonCreareSeBudgetTroppoBasso() throws InterruptedException {
        acq.setBudget(1000000);
        assertNull("Oggetto creato anche se budget troppo basso", laferrari.create());
    }

    @AfterClass
    public static void deallocate() {
        acq = null;
        cat = null;
        riv = null;
        laferrari = null;
    }
}