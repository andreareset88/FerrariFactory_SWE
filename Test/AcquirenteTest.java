
import org.junit.*;

import static org.junit.Assert.*;

public class AcquirenteTest {
    private static Acquirente acq;

    @BeforeClass
    public static void initialize() {
        acq = Acquirente.getInstance(1,1, 7500000, "Charles", 789543, 997, "MN654GH");
        assertNotNull("Acquirente non inizializzato", acq);
    }

    @Before
    public void setUp() throws Exception {
        acq.setTipoAuto(1);
        acq.setVersione(1);
        assertNotNull("Acquirente non inizializzato", acq);
    }
    @Test
    public void attesaSF90DeluxeMaggioreUguale75(){
        assertTrue("Tempo di attesa non corretto", acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione()) >= 75);
        acq.setVersione(0);
        assertEquals("SF90 standard richiede 75", 75, acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione()));
    }

    @Test
    public void polizzaSF90uguale23500LaFerrari21000(){
        assertEquals("Polizza SF90 sbagliata", 23500, acq.calcolaPolizza(1050), 0.0);
        acq.setTipoAuto(0); // imposto LaFerrari
        assertEquals("Polizza LaFerrari sbagliata", 21000, acq.calcolaPolizza(963), 0.0);
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
        assertFalse("Ordine cancellato anche se costo rientra nella soglia", acq.cancellaOrdine(acq.calcolaPolizza(1050)));
        assertTrue("Oridne non cancellato se costo troppo alto", acq.cancellaOrdine(5000000));
    }
    @AfterClass
    public static void deallocate() {
        acq = null;
    }
}