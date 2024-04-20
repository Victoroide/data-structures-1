package TDA_Polynomials;

public class Monomial {
    private int coef;
    private int exp;

    public Monomial() {
        this.coef = 0;
        this.exp = 0;
    }

    public Monomial(char signo, int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.setSigno(signo);
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void setExp(int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Exponente no puede ser negativo");
        }
        this.exp = exp;
    }

    public void setSigno(char signo) {
        if (signo == '-') {
            this.coef = -Math.abs(this.coef);
        }
    }

    public int getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public void sumar(Monomial m) {
        if (this.exp == m.exp) {
            this.coef += m.coef;
        } else {
            throw new IllegalArgumentException("No se pueden sumar monomios de diferente exponente");
        }
    }

    @Override
    public String toString() {
        if (coef == 0) return "";
        String coefStr = (coef == 1 && exp != 0) ? "" : String.valueOf(Math.abs(coef));
        String signStr = (coef < 0) ? "-" : "";
        if (exp == 0) return signStr + Math.abs(coef);
        if (exp == 1) return signStr + coefStr + "X";
        return signStr + coefStr + "X^" + exp;
    }
}
