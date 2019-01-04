import java.sql.*;
import java.util.LinkedList;

public class Kadry {
    public LinkedList<Pracownik> kadra;
    public PreparedStatement pstmt;
    public Connection conn;
    private Statement stmt;
    private ResultSet rs;
    public void add(Pracownik prac) {
        if (kadra.isEmpty()) {
            kadra.addFirst(prac);
        } else {
            kadra.add(prac);
        }
    }
    public Kadry(){
        kadra=new LinkedList<>();
    }
    public void remove(Pracownik prac) throws SQLException {
        kadra.remove(prac);
        connect();
        pstmt = conn.prepareStatement("delete from pracownik where pesel = ?");
        pstmt.setString(1, prac.getPes().getPesel());
        pstmt.execute();
        conn.close();
    }
    public Pracownik find(Pesel pes){
        for(Pracownik n:kadra){
            if(n.getPes().equals(pes)){
                return n;
            }
        }

        try {
            connect();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM pracownik WHERE pesel=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, pes.getPesel());
            rs=pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()){
                String name=new String();
                String pesel = rs.getString(1);
                Double wynagrodzenie=rs.getDouble(2);
                String typ=rs.getString(3);
                name=pesel+", "+wynagrodzenie+", "+typ;
                if(typ.equals("student")){
                    Student f =new Student(new Pesel(pesel),wynagrodzenie);
                    System.out.println("Pracownik: "+name);
                    System.out.println(f);
                    return f;
                }
                else{
                    Pracowniketatowy f =new Pracowniketatowy(new Pesel(pesel),wynagrodzenie);
                    System.out.println("Pracownik: "+name);
                    System.out.println(f);
                    return f;
                }
            }
            System.out.println(rs.toString());
        }catch (SQLException ex){

        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        return null;
    }
    public void changeWyn(Pracownik p, double _wyn){
        for(Pracownik n:kadra){
            if(n.equals(p)){
                n.changeW(_wyn);
            }
        };
    }

    public double getWynB(Pracownik p){
        return find(p.getPes()).getWynagrodzenieBrutto();
    }

    public double getWynN(Pracownik p){
        return find((p.getPes())).wylicznetto();
    }

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/mkutyla",
                            "mkutyla","qDfpzgcrJWKwdftF");
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch(Exception e){e.printStackTrace();}
    }
}