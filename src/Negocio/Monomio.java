package Negocio;

public class Monomio {
    private int coef;
    private int exp;

    public Monomio() {
        this.coef = 0;
        this.exp = 0;
    }

    public Monomio(char signo, int coef, int exp) {
        setExp(exp);
        setCoef(coef);
        setSigno(signo);
    }

    public void setExp(int exp) {
        this.exp = Math.max(exp, 0);
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void setSigno(char signo) {
        if (signo == '-') {
            this.coef = -Math.abs(this.coef);
        } else {
            this.coef = Math.abs(this.coef);
        }
    }

    public int getCoef() {
        return this.coef;
    }

    public int getExp() {
        return this.exp;
    }

    @Override
    public String toString() {
        if (this.coef == 0) {
            return "";
        }
        if (this.exp == 0) {
            return String.format("%d", this.coef);
        }
        if (this.coef == 1) {
            return (this.exp == 1) ? "X" : "X^" + this.exp;
        }
        if (this.coef == -1) {
            return (this.exp == 1) ? "-X" : "-X^" + this.exp;
        }
        return String.format("%dX^%d", this.coef, this.exp);
    }

    public void sumar(Monomio otro) {
        if (this.exp == otro.exp) {
            this.coef += otro.coef;
        }
    }
}
