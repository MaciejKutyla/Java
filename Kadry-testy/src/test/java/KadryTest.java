import static org.junit.Assert.*;

import org.junit.Test;

public class KadryTest {

    @Test
    public void findTest (){
        Pesel jakispesel = new Pesel("97185408381");
        Student maciek = new Student(jakispesel,750 );
        Kadry kadry  = new Kadry();
        kadry.add(maciek);
        assertEquals(maciek, kadry.find(jakispesel));
    }

    @Test
    public void addTest(){
        Pesel jakispesel = new Pesel("97185408381");
        Student maciek = new Student(jakispesel,750 );
        Kadry kadry = new Kadry();
        kadry.add(maciek);
        assertEquals(true, kadry.kadra.isEmpty());

    }

}