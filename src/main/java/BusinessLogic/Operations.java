package BusinessLogic;
import java.util.Map;

import DataModules.Monomial;
import DataModules.Polynomial;

public class Operations {
    private Polynomial pol1;
    private Polynomial pol2;

    public Operations(Polynomial pol1, Polynomial pol2) {
        this.pol1 = pol1;
        this.pol2 = pol2;
    }

    public static Monomial additionM(Monomial m1, Monomial m2) {
        Monomial rez = new Monomial(0.0, 0);

        if (m1.getPower() == m2.getPower()) {
            rez.setPower(m1.getPower());
            rez.setCoefficient(m1.getCoefficient() + m2.getCoefficient());
        } else
            System.out.println("You can't add up two monomials with different powers.");

        System.out.println("R :  " + rez);
        return rez;

    }

    public static Monomial subctractionM(Monomial m1, Monomial m2) {
        Monomial rez = new Monomial(0.0, 0);

        if (m1.getPower() == m2.getPower()) {
            rez.setPower(m1.getPower());
            rez.setCoefficient(m1.getCoefficient() - m2.getCoefficient());
        }

        else
            System.out.println("You can't subtrct two monomials with different powers.");

        System.out.println("R :  " + rez);
        return rez;

    }

    public static Polynomial additionP(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        Monomial r = new Monomial(0.0, 0);

        for (Map.Entry<Integer, Double> entry1 : p1.getH().entrySet()) {
            //if (entry1 != null) {
            if (p2.getH().get(entry1.getKey()) != null) {
                r.setCoefficient(entry1.getValue() + p2.getH().get(entry1.getKey()));
                r.setPower(entry1.getKey());
                rez.addM(r);
            } else {
                r.setPower(entry1.getKey());
                r.setCoefficient(entry1.getValue());
                rez.addM(r);
            }
        }
        //}
        for (Map.Entry<Integer, Double> entry2 : p2.getH().entrySet()) {
            if (entry2 != null) {
                if (p1.getH().get(entry2.getKey()) == null) {
                    r.setPower(entry2.getKey());
                    r.setCoefficient(entry2.getValue());
                    rez.addM(r);
                }
            }

        }

        return rez;
    }

    public static Polynomial subtractionP(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        Monomial r = new Monomial(0.0, 0);
        for (Map.Entry<Integer, Double> entry1 : p1.getH().entrySet()) {
            //if (entry1 != null) {
            if (p2.getH().get(entry1.getKey()) != null) {
                r.setCoefficient(entry1.getValue() - p2.getH().get(entry1.getKey()));
                r.setPower(entry1.getKey());
                rez.addM(r);
            } else {
                r.setPower(entry1.getKey());
                r.setCoefficient(entry1.getValue());
                rez.addM(r);
            }
        }
        for (Map.Entry<Integer, Double> entry2 : p2.getH().entrySet()) {
            if (entry2 != null) {
                if (p1.getH().get(entry2.getKey()) == null) {
                    r.setPower(entry2.getKey());
                    r.setCoefficient(-entry2.getValue());
                    rez.addM(r);
                }}
        }
        return rez;
    }


    public static Polynomial multiplication(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry1 : p1.getH().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.getH().entrySet()) {
                if (result.getH().containsKey(entry1.getKey() + entry2.getKey())) {
                    Double oldV = result.getH().get(entry1.getKey() + entry2.getKey());
                    Double newV = oldV + (entry1.getValue() * entry2.getValue());
                    result.getH().replace(entry1.getKey() + entry2.getKey(), oldV, newV);
                }

                else {
                    result.addM(new Monomial(Math.round(entry1.getValue() * entry2.getValue()*1000)/1000, entry1.getKey() + entry2.getKey()));
                }

            }
        }

        return result;

    }

    public static Polynomial derivation(Polynomial p1)
    {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : p1.getH().entrySet()) {
            Double c = entry1.getKey() * entry1.getValue();
            Integer p = entry1.getKey() - 1;

            result.addM(new Monomial(Math.round(c * 1000) / 1000, p));

        }
        return result;

    }

    public static Polynomial integration(Polynomial p1)
    {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : p1.getH().entrySet()) {
            Double c = entry1.getValue() / (entry1.getKey() + 1) ;
            Integer p = entry1.getKey() + 1;

            result.addM(new Monomial(c,p));
        }

        return result;

    }
}
