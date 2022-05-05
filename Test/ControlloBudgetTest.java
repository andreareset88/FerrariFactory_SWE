import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControlloBudgetTest {
    private static Acquirente acq;

    @BeforeClass
    public static void initialize() {
        acq = Acquirente.getInstance(0,1, 5000000, "Charles", 12344, 444, "NBV678UI");
        ControlloBudget.setAcq(acq);
    }

    @Before
    public void setUp() {
        assertNotNull("Acquirente non inizializzato", acq);
    }
    @Test
    public void cancellaSeBudgetMinorePrezzo(){
        assertTrue("Acquisto non consentito con prezzo giusto", ControlloBudget.checkBudget(4000000));
        assertTrue("Acquisto non consentito con prezzo giusto", ControlloBudget.checkBudget(5000000));
        assertFalse("Acquisto consentito anche con budget piccolo", ControlloBudget.checkBudget(5000001));
    }

    @After
    public void tearDown() throws Exception {
        acq = null;
    }
}