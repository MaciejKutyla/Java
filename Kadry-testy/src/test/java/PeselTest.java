import static org.junit.Assert.*;

import org.junit.Test;

public class PeselTest {

    @Test
        public void goodlengthofpesel(){

        Pesel toolong = new Pesel("1234567891011");
        Pesel tooshort = new Pesel("1234");
        Pesel goodpesel = new Pesel("98100301439");
        assertEquals(false, tooshort.chceck());
        assertEquals(false, toolong.chceck());
        assertEquals(true, goodpesel.chceck());

    }
}