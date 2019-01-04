import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class Pracownik{
    private Pesel pes;
    private double wynagrodzenieBrutto;
    Connection conn;

    abstract public int wylicznetto();

    public Pesel getPes() {
        return pes;
    }

    public double getWynagrodzenieBrutto() {
        return wynagrodzenieBrutto;
    }

    public void changeW(double _wyn){
        wynagrodzenieBrutto=_wyn;
    }

    public Pracownik(Pesel pesel, double wyn){
        pes=pesel;
        wynagrodzenieBrutto=wyn;
    }
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/mkutyla",
                            "mkutyla","qDfpzgcrJWKwdftF");
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch(Exception e){e.printStackTrace();}
    }
}