import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Osoby extends Application {
    public static final String LUDZKO = "Ludzko";
    ArrayList<Osoba> ludzie = new ArrayList<>();

    TextField n = new TextField();
    TextField s = new TextField();
    TextField a = new TextField();

    Label nl = new Label(" Imię: ");
    Label sl = new Label(" Nazwisko: ");
    Label al = new Label(" Wiek: ");

    Button btn = new Button();

    GridPane grid = new GridPane();
    VBox people = new VBox();
    VBox root = new VBox();

    private int count = 0;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }


    private void initUI(Stage stage) {
        btn.setText("Dodaj osobę");
        btn.setOnAction((ActionEvent event) -> {
            add();
        });


        grid.setConstraints(nl, 0, 0);
        grid.setConstraints(sl, 0, 1);
        grid.setConstraints(al, 0, 2);

        grid.setConstraints(n, 1, 0);
        grid.setConstraints(s, 1, 1);
        grid.setConstraints(a, 1, 2);

        grid.setConstraints(btn, 1, 3);

        grid.getChildren().addAll(nl,sl,al,n,s,a,btn);

        root.getChildren().addAll(grid,people);

        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("LUDZKOŚĆ");
        stage.setScene(scene);
        stage.show();
    }

    private void add() {
        try {
            String nn = n.getText();
            String ss = s.getText();
            int aa = Integer.valueOf(a.getText());
            Osoba ba=new Osoba(nn,ss,aa);
            ludzie.add(ba);
            n.clear();
            s.clear();
            a.clear();

            count++;



            Text ludz = new Text();
            ludz.setText(count+". "+nn+" "+ss+" "+aa);


            HBox entry = new HBox();
            entry.getChildren().add(ludz);

            people.getChildren().add(entry);

        } catch (Throwable a) {
            System.out.println("Błąd dodawania osoby. Sprawdź dane wejściowe.");
            new Alert(Alert.AlertType.ERROR, "Błąd dodawania osoby. Sprawdź dane wejściowe.").showAndWait();
        }



    }
    
    public static void main(String[] args) {
        launch(args);
    }


}