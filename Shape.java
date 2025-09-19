import java.util.*;
import bank.*;

class Shape {
    public void area(){
        System.out.println("dispaly area");

    }
}

class Triangle extends Shape {
    //extends use to inherit the properties of one class to another class
    //derived class , extend keyword, base class
    public void area(int l, int h){
        System.out.println(1/2*l*h);
    }
}
//  class EquilateralTraingle extends Traingle{
//     public void area (int l , int h){
//         System.out.println(1/2*l*h);
//     }
//  }

class Circle extends Shape {
    //hierarchical inheritance
    public void area(int r){
        System.out.println(3.14*r*r);
    }
}

public class OOPS {
    public static void main (String arg[]){
      bank.Account account1 = new bank.Account();
      account1.name =" Customer1";
    }
} 