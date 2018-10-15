import static java.lang.Math.*;
import java.util.Scanner;

public class Punkt3D extends Punkt2D {
    private double z;
    public Punkt3D ( double _x, double _y, double _z){
        super(_x,_y);
        z = _z;
    }
    public double getZ(){
        return z;
    }
    public void setZ(double _z){
        z = _z;
    }
    public double distance (Punkt3D p){
        return (Math.sqrt(Math.pow(this.getX()-p.getX(),2)+Math.pow(this.getY()-p.getY(),2)+Math.pow(z-p.z,2)));
    }
}
