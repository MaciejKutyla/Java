package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.IOException;

import static java.lang.Math.*;

public class Controller {
    @FXML
    private javafx.scene.control.TextField x0, x1, x2, x3, x4, begin, end, krok;
    private int x0_, x1_, x2_, x3_, x4_;
    private double begin_, end_, krok_;

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void setX0_(int x0_) { this.x0_ = x0_; }

    public void setX1_(int x1_) {
        this.x1_ = x1_;
    }

    public void setX2_(int x2_) {
        this.x2_ = x2_;
    }

    public void setX3_(int x3_) {
        this.x3_ = x3_;
    }

    public void setX4_(int x4_) {
        this.x4_ = x4_;
    }

    public void setBegin_(double begin_) {
        this.begin_ = begin_;
    }

    public void setEnd_(double end_) {
        this.end_ = end_;
    }

    public void setKrok_(double krok_) {
        this.krok_ = krok_;
    }

    double wynik(double x) {
        return ((pow(x, 4) * x4_) + (x3_ * pow(x, 3)) + (x2_ * pow(x, 2)) + (x1_ * pow(x, 1)) + (x0_ * pow(x, 0)));
    }
    public void draw2(ActionEvent actionEvent) throws IOException {
        if(isNumeric(x0.getText())){
            setX0_(Integer.parseInt(x0.getText()));
        }
        if(isNumeric(x1.getText())){
            setX1_(Integer.parseInt(x1.getText()));
        }
        if(isNumeric(x2.getText())){
            setX2_(Integer.parseInt(x2.getText()));
        }
        if(isNumeric(x3.getText())){
            setX3_(Integer.parseInt(x3.getText()));
        }
        if(isNumeric(x4.getText())){
            setX4_(Integer.parseInt(x4.getText()));
        }
        if (isNumeric(begin.getText())) {
            setBegin_(Double.parseDouble(begin.getText()));
        }
        if (isNumeric(end.getText())) {
            setEnd_((Double.parseDouble(end.getText())));
        }
        if (isNumeric(krok.getText())) {
            setKrok_((Double.parseDouble(krok.getText())));
        }
        if ((!begin.getText().isEmpty() && begin_ == 0) || (!end.getText().isEmpty() && end_ == 0) || (!krok.getText().isEmpty() && krok_ == 0) || (!x0.getText().isEmpty() && x0_ ==0) || (!x1.getText().isEmpty() && x1_ ==0) || (!x2.getText().isEmpty() && x2_ ==0) || (!x3.getText().isEmpty() && x3_ ==0) || (!x4.getText().isEmpty() && x4_ ==0)) {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("sample3.fxml"));
            stage.setScene(new Scene(root, 600, 475));
            stage.show();
        }
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        yAxis.setLabel("y");
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Wielomian" + x4_ + "x^4+" + x3_ + "x^3+" + x2_ + "x^2+" + x1_ + "x+" + x0_);
        XYChart.Series series = new XYChart.Series();
        series.setName("Częstotliwość probkowania");
        for (double i = begin_; i < end_; i += krok_) {
            series.getData().add(new XYChart.Data(i, wynik(i)));
        }
        lineChart.getData().add(series);
        Scene scene = new Scene(lineChart, 1200, 900);

        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}