// Tester Class for Problem 3
import java.lang.Math;
public class RightTriangleTester {
  public static void main(String[] args) {
    RightTriangle a = new RightTriangle(3,4);
    System.out.println("The hypotenues is "+a.get_hypotenus());
    System.out.println("The area is "+a.getArea());
    System.out.println("The perimeter is "+a.getPerimeter());
    System.out.println("Angle theta = "+a.getAngle1()+" radians");
    System.out.println("Angle alpha = "+ a.getAngle2() +" radians");
  }
}