package felder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRmethods {

    @Test
    public void testKleinsterWiderstand() {
        double[] r = {1.5,10,7};
        assertEquals(1.5, Rmethods.kleinsterWiderstand(r),0.00001);
        assertEquals(2, Rmethods.kleinsterWiderstand(new double[]{3,2,6}),0.00001);
    }

}
