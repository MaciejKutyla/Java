
public class LiczbyPierwsze {
    public int number;

    public LiczbyPierwsze(int _number) {
        number = _number;
    }

    public static void search(int number) {
        boolean liczbyPierwsze[] = new boolean[number];
        liczbyPierwsze[0] = false;
        liczbyPierwsze[1] = false;
        for (int i = 2; i < number; i++)
            liczbyPierwsze[i] = true;
        for (int j = 2; j < number; j++) {
            if (liczbyPierwsze[j] == true) {
                for (int k = 2 * j; k < number; k = k + j) {
                    liczbyPierwsze[k] = false;
                }
            }
        }
        for (int l = 0; l < liczbyPierwsze.length; l++) {
            if (liczbyPierwsze[l]) {
                System.out.println(l);
            }
        }
    }
}