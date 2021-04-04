// Problem 3 Right Triangle
import java.lang.Math;
public class RightTriangle {
  private double side1;
  private double side2;
  
  public RightTriangle(double a, double b){
    side1 = a;
    side2 = b;
  }
  public double get_hypotenus(){
    double Hyp = Math.sqrt(Math.pow(side1,2)+Math.pow(side2,2));
    return Hyp;
  }
  public double getAngle1(){
    double theta = Math.atan(side2 / side1);
    return theta;
  }
  public double getAngle2(){
    double alpha = 1.5708 - Math.atan(side2 / side1);
    return alpha;
  }
  public double getArea(){
    double Area = (side1 * side2) / 2;
    return Area;
  }
  public double getPerimeter(){
    double P = side1 + side2 + Math.sqrt(Math.pow(side1,2)+Math.pow(side2,2));
    return P;
  }
}
