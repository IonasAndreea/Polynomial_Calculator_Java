package DataModules;

public class Monomial {
    private Double coefficient;
    private Integer power;

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;

    }

    public Double getCoefficient() {
        return coefficient;
    }

    public Integer getPower() {
        return power;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        String monom = "";
        if (coefficient == 0)
            return "";
        if (power == 0)
            return coefficient.toString();
        if (coefficient == 1)
            return " X" + power;
        if (coefficient != 1)
            return coefficient + "*X" + power + " ";

        return monom;
    }

}

