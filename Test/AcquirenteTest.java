
import AbstractFactory.*;
import Observer.*;
import org.junit.*;

import static org.junit.Assert.*;

public class AcquirenteTest {
    private static Acquirente acq;

    @BeforeClass
    public static void initialize() {
        // Observer.Acquirente inizializzato con sf90 deluxe
        acq = Acquirente.getInstance(1,1, 10000000, "Charles", 789543, 997, "MN654GH");
        assertNotNull("Observer.Acquirente non inizializzato", acq);
    }

    @Before
    public void setUp() throws Exception {
        acq.setTipoAuto(1);
        acq.setVersione(1);
        assertNotNull("Observer.Acquirente non inizializzato", acq);
    }
    @Test
    public void attesaSF90DeluxeMaggioreUguale75(){
        assertEquals("SF90 deluxe richiede 95", 95, acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione()));
        acq.setVersione(0);
        assertEquals("SF90 standard richiede 75", 75, acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione()));
    }

    @Test
    public void polizzaSF90uguale23500LaFerrari21000(){
        SF90StradaleDeluxe sf90StradaleDeluxe = new SF90StradaleDeluxe(1050, true, true, 5000000, acq, null, null);
        assertEquals("Polizza SF90 sbagliata", 23500, acq.calcolaPolizza(sf90StradaleDeluxe.getHp()), 0.0);
        LaFerrariDeluxe ferrariDeluxe = new LaFerrariDeluxe(963, true, true, 3000000, acq, null, null);
        assertEquals("Polizza AbstractFactory.LaFerrari sbagliata", 21000, acq.calcolaPolizza(ferrariDeluxe.getHp()), 0.0);
    }

    @Test
    public void revisioneTest() throws InterruptedException {
        acq.setGiorniPassati(1100);
        acq.setKmPercorsi(5000);
        assertTrue("Richiamo revisione errato", acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()));
        acq.setGiorniPassati(1000); // Con 1000 giorni e 5000 km non è tempo di revisione
        assertFalse("Richiamo revisione errato", acq.checkRevisione(acq.getGiorniPassati(), acq.getKmPercorsi()));
    }

    @Test
    public void cancellaOrdineSeMaggiore40PercentoBudget(){
        SF90StradaleDeluxe sf90StradaleDeluxe = new SF90StradaleDeluxe(1050, true, true, 5000000, acq, null, null);
        assertFalse("Ordine cancellato anche se costo rientra nella soglia", acq.cancellaOrdine(acq.calcolaPolizza(sf90StradaleDeluxe.getHp())));
        assertTrue("Oridne non cancellato se costo troppo alto", acq.cancellaOrdine(5000000));
    }
    @AfterClass
    public static void deallocate() {
        acq = null;
    }
}