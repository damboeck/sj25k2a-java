package mathematik;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestsMathe {

    @Test
    public void testeZiffernsumme1(){
        assertEquals(Ziffernsumme.zs(12345), 15);
        assertEquals(Ziffernsumme.zs(0), 0);
        assertEquals(Ziffernsumme.zs(9), 9);
    }

    @Test
    public void testeZiffernsumme2(){
        assertEquals(Ziffernsumme.zs(22345), 16);
        assertEquals(Ziffernsumme.zs(99999), 45);
        assertEquals(Ziffernsumme.zs(-138), -12);
    }

}
