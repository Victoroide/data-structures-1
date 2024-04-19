package Negocio;

public class Monomio {
    private int coef;
    private int exp;

    public Monomio() {
        this.coef = 0;
        this.exp = 0;
    }

    public Monomio(char signo, int coef, int exp) {
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

    public void sumar(Monomio m) {
        if (this.exp == m.exp) {
            this.coef += m.coef;
        } else {
            throw new IllegalArgumentException("No se pueden sumar monomios de diferente exponente");
        }
    }

    @Override
    public String toString() {
        if (coef == 0) return "";
        if (exp == 0) return String.format("%d", coef);
        String coefStr = (Math.abs(coef) == 1 && exp != 0) ? "" : String.format("%d", Math.abs(coef));
        String signStr = (coef < 0) ? "-" : "";
        return String.format("%s%sX%s", signStr, coefStr, (exp == 1) ? "" : "^" + exp);
    }
}
