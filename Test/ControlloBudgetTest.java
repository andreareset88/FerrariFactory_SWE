import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlloBudgetTest {
    private static Acquirente acq;

    @Before
    public void setUp() throws Exception {
        acq = Acquirente.getInstance(0,1, 5000000, "Charles", 12344, 444, "NBV678UI");
        ControlloBudget.setAcq(acq);
    }

    @Test
    public void falsoSeBudgetMinorePrezzo(){
        assertTrue("Acquisto non consentito", ControlloBudget.checkBudget(4000000));
        assertFalse("Acquisto non consentito con prezzo giusto", ControlloBudget.checkBudget(5000000));
    }

    @After
    public void tearDown() throws Exception {
        acq = null;
    }
}