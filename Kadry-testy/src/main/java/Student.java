import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student extends Pracownik {
    public PreparedStatement pstmt;
    public Student(Pesel pesel, double wyn) {
        super(pesel, wyn);
        connect();
        String np;
        try {
            pstmt = conn.prepareStatement("insert into pracownik values (?,?,?);");
            pstmt.setString(1, pesel.getPesel());
            pstmt.setString(2, String.valueOf(wyn));
            pstmt.setString(3, "student");
            pstmt.execute();
            np="Dodano";

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            np="Nie dodano";
        }
    }

    @Override
    public int wylicznetto() {
        return 0;
    }

    @Override
    public void changeW(double _wyn) {
        super.changeW(_wyn);
    }
}