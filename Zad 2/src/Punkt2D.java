import static java.lang.Math.*;
import java.util.Scanner;

public class Punkt2D {
    private double x;
    private double y;
    public Punkt2D ( double _x, double _y){
        x = _x;
        y = _y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double _x){
        x = _x;
    }
    public void setY(double _y){
        y = _y;
    }
    public double distance(Punkt2D p){
        return (Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2)));
    }
}
