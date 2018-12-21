
import java.io.File;
import java.io.PrintWriter;

public class GenerateRandoms {

    int r;

    public void fill(){
        try {
            File nums = new File("nums.txt");
            PrintWriter writer = new PrintWriter(nums, "UTF-8");
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    r = (int) (Math.random() * 50 + 1);
                    writer.print(r + " ");
                }
                writer.print("\n");
            }
            writer.close();
        }
        catch (Exception a){}

    }}