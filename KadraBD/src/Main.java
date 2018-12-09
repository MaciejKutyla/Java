import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Student maciek = new Student(new Pesel("97185408381"),750 );
        Student tomek = new Student(new Pesel("97122104902"),750 );
        Student szymon= new Student(new Pesel("97122111383"),750 );
        Pracowniketatowy niemaria = new Pracowniketatowy(new Pesel("97122108384"),1950 );
        Kadry lol = new Kadry();
        lol.add(maciek);
        lol.remove(maciek);
        lol.add(tomek);
        lol.add(szymon);
        lol.find(new Pesel("97122111383"));

    }
}