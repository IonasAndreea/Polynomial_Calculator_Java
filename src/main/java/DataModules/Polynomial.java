package DataModules;
import java.util.*;

public class Polynomial {
    private TreeMap<Integer, Double> h = new TreeMap<>();


    public Polynomial() {
        h = new TreeMap<Integer, Double>(Collections.reverseOrder());
    }

    public void addM(Monomial mo) {
        h.put(mo.getPower(), mo.getCoefficient());

    }

    public TreeMap<Integer, Double> getH() {
        return h;
    }

    public void setH(TreeMap<Integer, Double> h) {
        this.h = h;
    }


// toString

    @Override
    public String toString() {
        String poli = "";
        Monomial m = new Monomial(0.0,0);

        for (Map.Entry<Integer, Double> entry : h.entrySet()) {
            m.setCoefficient(entry.getValue());
            m.setPower(entry.getKey());
            if(m.getCoefficient() <= 0 )
                poli += m.toString() + " ";
            else
                poli += "+" + m.toString();

        }

        return poli;
    }

    public boolean equals(Polynomial o) {
        for(Map.Entry<Integer, Double> termen : h.entrySet()) {
            if(o.getH().containsKey(termen.getKey())) {
                if(!Objects.equals(o.getH().get((termen.getKey())), termen.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(h);
    }
}
