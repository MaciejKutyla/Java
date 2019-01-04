import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pracowniketatowy extends Pracownik {
    public PreparedStatement pstmt;
    public Pracowniketatowy(Pesel pesel, double wyn) {
        super(pesel, wyn);
        connect();
        String np;
        try {
            pstmt = conn.prepareStatement("insert into pracownik values (?,?,?);");
            pstmt.setString(1, pesel.getPesel());
            pstmt.setString(2, String.valueOf(wyn));
            pstmt.setString(3, "pracownik");
            pstmt.execute();

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int wylicznetto() {
        return 0;
    }

    @Override
    public Pesel getPes() {
        return super.getPes();
    }

    @Override
    public void changeW(double _wyn) {
        super.changeW(_wyn);
    }
}