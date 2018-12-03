import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;


    public void connect() {
        int count = 0;
        int failed = 0;
        do {
            count++;
            System.out.println("Próba połączenia " + count);
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn =
                        DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/mkutyla",
                                "mkutyla", "qDfpzgcrJWKwdftF");
                System.out.println("Connected.");


            } catch (SQLException ex) {
                failed++;
                System.out.println("Błąd!");
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } catch (Exception e) {
                failed++;
                System.out.println("Błąd!");
                e.printStackTrace();
            }
        } while (failed >= count && count < 3);
        if (failed > 2) {
            System.out.println("Połączenie nie zostało nawiązane.");
        }
    }

    public void selectAll() {
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                System.out.println(isbn + "   " + title + "   " + author + "  " + year);

            }
        } catch (SQLException ex) {
            // handle any errors

        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }

        }
    }

    public void search(String key) {
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                String isbn = rs.getString(1);

                String author = rs.getString(3);

                if (isbn.equals(key)) {
                    String title = rs.getString(2);
                    String year = rs.getString(4);
                    System.out.println(isbn + "   " + title + "   " + author + "  " + year);
                }
                if(author.toLowerCase().contains(key.toLowerCase())){
                    String title = rs.getString(2);
                    String year = rs.getString(4);
                    System.out.println(isbn + "   " + title + "   " + author + "  " + year);
                }


            }
        } catch (SQLException ex) {
            // handle any errors

        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }

        }

    }

    public void add(String isbn, String title, String author, String bookyear) {
        try {
            connect();
            stmt = conn.createStatement();
            String sql = "INSERT INTO books "
                    + "VALUES('" + isbn + "','" + title + "','" + author + "','" + bookyear + "')";
            System.out.println(sql);
            stmt.executeUpdate(sql);


        } catch (SQLException sqlEx) {
        } catch (Exception e) {
            e.printStackTrace();
        }}

    public void remove(String author_){
            try {
                connect();
                stmt = conn.createStatement();
                String sq2 = "DELETE FROM books"+ " WHERE author = '" + author_ + "'";
                stmt.executeUpdate(sq2);


            } catch (SQLException sqlEx) {
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void menu() {
        int i;
        String isbn, title, author, bookyear;

        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        do {
            System.out.println("1. Dodaj książkę\n" +
                    "2. Wyświetl wszystkie\n" +
                    "3. Szukaj\n" +
                    "4. Usuń ksiązki autora\n"+
                    "5. Zakończ\n" + "?");


            i = scan.nextInt();
            scan.nextLine();

            if (i == 1) {
                System.out.println("ISBN: ");
                isbn = scan.nextLine();

                System.out.println("Tytuł: ");
                title = scan.nextLine();

                System.out.println("Autor: ");
                author = scan.nextLine();

                System.out.println("Rok wydania: ");
                bookyear = scan.nextLine();

                add(isbn, title, author, bookyear);

            }

            if (i == 2) {

                selectAll();
            }

            if (i == 3) {
                System.out.println("Wyszukaj isbn/autora: ");
                isbn = scan.nextLine();
                search(isbn);
            }
            if (i == 4){
                System.out.println("Podaj autora książek, które mam usunąć: ");
                author = scan.nextLine();
                remove(author);
            }

        } while (i != 5);

    }

}