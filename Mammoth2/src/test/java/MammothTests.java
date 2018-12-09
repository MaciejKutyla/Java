import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.File;

public class MammothTests {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testEat() throws Exception {
        expectedEx.expect(InadequateFoodException.class);
        expectedEx.expectMessage("I don't like meat");
        Mammoth merlin=new Mammoth();
        Meat jedzonko=new Meat();
        merlin.eat(jedzonko);
        System.out.print("Test ukończony poprawnie");
    }
    @Test
    public void testing(){
        try {
            File file = new File("file.txt");
            testEat();
            file.delete();
        }
        catch(Throwable a){
            System.out.print("Test nie ukończony poprawnie");
        }

    }
}