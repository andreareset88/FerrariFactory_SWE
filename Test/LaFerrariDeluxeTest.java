import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LaFerrariDeluxeTest {
    private Acquirente acq;
    private Catalogo cat;
    private Rivenditore riv;
    private LaFerrariDeluxe laferrari;

    @Before
    public void setUp() throws Exception {
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

    @After
    public void tearDown() throws Exception {
        acq = null;
        cat = null;
        riv = null;
        laferrari = null;
    }
}