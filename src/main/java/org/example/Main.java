package org.example;
import DataModules.Monomial;
import DataModules.Polynomial;
import GraphicalUserInterface.Calculator;
import BusinessLogic.Operations;
import BusinessLogic.Controller;
public class Main {
    public static void main(String[] args)
    {
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial m3 = new Monomial(1, 0);
        Monomial m4 = new Monomial(2,3);
        Monomial m5 = new Monomial(4,2);
        Monomial m6 = new Monomial(-1,1);

        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.addM(m1);
        p1.addM(m2);
        //p1.addM(m3);
        p2.addM(m1);
        p2.addM(m2);
        //p2.addM(m6);



        System.out.println("------------------------");
        System.out.println(p1.equals(p2));


        System.out.println("------------------------");

        System.out.println(p2.toString());
        System.out.println(p1.toString());


        System.out.println("------------------------");

        System.out.println(Operations.additionP(p2, p1));


        System.out.println("------------------------");

        System.out.println(Operations.subtractionP(p2, p1));

        System.out.println("------------------------");

        System.out.println(Operations.multiplication(p2, p1));

        System.out.println("------------------------");

        System.out.println(Operations.derivation(p1));

        System.out.println("------------------------");

        System.out.println("Aici");
        System.out.println(Operations.integration(p1));



        Calculator calc = new Calculator();
        Controller cont = new Controller(calc);

    }
}