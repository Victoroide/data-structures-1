package TDA_Polynomials;

import java.util.Arrays;
import java.util.Comparator;

public class Polynomial {
    private Monomial[] p;
    private int dim;

    public Polynomial(int size) {
        p = new Monomial[size];
        dim = -1;
    }

    public void insert(char sign, int coef, int exp) {
        if (coef == 0) return;
        Monomial new_obj = new Monomial(sign, coef, exp);
        boolean found = false;
        for (int i = 0; i <= dim; i++) {
            if (p[i].getExp() == exp) {
                p[i].sum(new_obj);
                if (p[i].getCoef() == 0) {
                    remove(i);
                }
                found = true;
                break;
            }
        }
        if (!found) {
            if (dim + 1 == p.length) {
                resize();
            }
            p[++dim] = new_obj;
        }
        sort_by_exponent();
    }

    private void sort_by_exponent() {
        Arrays.sort(p, 0, dim + 1, new Comparator<Monomial>() {
            @Override
            public int compare(Monomial m1, Monomial m2) {
                return m2.getExp() - m1.getExp();
            }
        });
    }

    private void resize() {
        p = Arrays.copyOf(p, p.length + 5);
    }

    private void remove(int index) {
        if (index < 0 || index > dim) return;
        System.arraycopy(p, index + 1, p, index, dim - index);
        p[dim] = null;
        dim--;
    }
    
    public Polynomial sum(Polynomial other) {
        Polynomial result = new Polynomial(this.p.length + other.p.length);
        for (Monomial monomial_obj : this.p) {
            if (monomial_obj != null) {
                result.insert('+', monomial_obj.getCoef(), monomial_obj.getExp());
            }
        }
        for (Monomial monomial_obj : other.p) {
            if (monomial_obj != null) {
                result.insert('+', monomial_obj.getCoef(), monomial_obj.getExp());
            }
        }
        return result;
    }

    public Polynomial subtract(Polynomial other) {
        Polynomial result = new Polynomial(this.p.length + other.p.length);
        for (Monomial monomial_obj : this.p) {
            if (monomial_obj != null) {
                result.insert('+', monomial_obj.getCoef(), monomial_obj.getExp());
            }
        }
        for (Monomial monomial_obj : other.p) {
            if (monomial_obj != null) {
                result.insert('-', monomial_obj.getCoef(), monomial_obj.getExp());
            }
        }
        return result;
    }

    public Polynomial multiply(Polynomial other) {
        Polynomial result = new Polynomial(this.p.length * other.p.length);
        for (Monomial monomial_objA : this.p) {
            if (monomial_objA != null) {
                for (Monomial monomial_objB : other.p) {
                    if (monomial_objB != null) {
                        int nuevoCoef = monomial_objA.getCoef() * monomial_objB.getCoef();
                        int nuevoExp = monomial_objA.getExp() + monomial_objB.getExp();
                        result.insert('+', nuevoCoef, nuevoExp);
                    }
                }
            }
        }
        return result;
    }
    
    public double evaluar(double x) {
        double result = 0.0;
        for (Monomial m : p) {
            if (m != null) {
                result += m.getCoef() * Math.pow(x, m.getExp());
            }
        }
        return result;
    }

    public Monomial getMonomial(int exponent) {
        for (Monomial m : p) {
            if (m != null && m.getExp() == exponent) {
                return m;
            }
        }
        return null; // Retorna null si no se encuentra el monomial_obj con el exponente dado.
    }

    @Override
    public String toString() {
        if (dim == -1) return "P(x)=0";
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= dim; i++) {
            s.append(p[i].toString());
            if (i < dim && p[i + 1].getCoef() > 0) {
                s.append(" + ");
            }
        }
        return "P(x)=" + s.toString();
    }
}
