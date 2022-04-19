import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcquirenteTest {
    Acquirente acq = Acquirente.getInstance(1,1,7500000, "Charles", 789543, 997, "MN654GH");

    @Test
    public void polizzaTest(){
        assertEquals(23500, acq.calcolaPolizza(1050));
    }

    @Test
    public void calcolaAttesaTest(){
        assertTrue(acq.calcolaAttesa(acq.getTipoAuto(), acq.getVersione()) >= 75);
    }
}