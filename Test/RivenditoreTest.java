import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RivenditoreTest {
    private Rivenditore riv;
    private Acquirente acq;
    private Catalogo cat;

    @Before
    public void setUp() throws Exception {
        acq = Acquirente.getInstance(2,0, 6000000, "Charles", 987654, 777, "MNFR567");
        cat = new Catalogo();
        riv = Rivenditore.getInstance(acq, null, cat);
    }

    @Test
    public void numeroAutoDisponibiliMinoreUguale5(){
        assertTrue("Numero auto non corretto", cat.getNumeroLaFerrari() <= 5 && cat.getNumeroLaFerrari()>= 0);
        assertTrue("Numero auto non corretto", cat.getNumeroSf90Stradale() <= 5 && cat.getNumeroSf90Stradale()>= 0);
        assertTrue("Numero auto non corretto", cat.getNumeroTestarossa() <= 5 && cat.getNumeroTestarossa()>= 0);
    }

    @Test
    public void checkAutoDisponibili(){
        cat.setNumeroLaFerrari(3);
        assertTrue("LaFerrari non disponibile", cat.isLaFerrari());
        cat.setNumeroSf90Stradale(0);
        assertFalse("SF90 Stradale non disponibile", cat.isSf90Stradale());
    }

    @Test
    public void profittoTest(){
        riv.setProfitto(450);
        assertEquals("Calcolo profitto non corretto", riv.aggiornaProfitto(2000000), 2000450, 0.0);
    }

    @Test
    public void pubblicizzaEIndiceGradimentoTra0e100() throws InterruptedException {
        assertTrue("Percentuale di gradimento incorretta", riv.pubblicizza() >= 0 && riv.pubblicizza() <= 100);
    }

    @After
    public void tearDown() throws Exception {
        acq = null;
        cat = null;
        riv = null;
    }
}