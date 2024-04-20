package TDA_Polynomials;

import java.util.Arrays;
import java.util.Comparator;

public class Polynomial {
    private Monomial[] p;
    private int dim;

    public Polynomial(int capacidad) {
        p = new Monomial[capacidad];
        dim = -1;
    }

    public void insertar(char signo, int coef, int exp) {
        if (coef == 0) return;
        Monomial nuevo = new Monomial(signo, coef, exp);
        boolean encontrado = false;
        for (int i = 0; i <= dim; i++) {
            if (p[i].getExp() == exp) {
                p[i].sumar(nuevo);
                if (p[i].getCoef() == 0) {
                    eliminar(i);
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            if (dim + 1 == p.length) {
                redimensionar();
            }
            p[++dim] = nuevo;
        }
        ordenarPorExponente();
    }

    private void ordenarPorExponente() {
        Arrays.sort(p, 0, dim + 1, new Comparator<Monomial>() {
            @Override
            public int compare(Monomial m1, Monomial m2) {
                return m2.getExp() - m1.getExp();
            }
        });
    }

    private void redimensionar() {
        p = Arrays.copyOf(p, p.length + 5);
    }

    private void eliminar(int index) {
        if (index < 0 || index > dim) return;
        System.arraycopy(p, index + 1, p, index, dim - index);
        p[dim] = null;
        dim--;
    }
    
    public Polynomial sumar(Polynomial otro) {
        Polynomial resultado = new Polynomial(this.p.length + otro.p.length);
        for (Monomial monomio : this.p) {
            if (monomio != null) {
                resultado.insertar('+', monomio.getCoef(), monomio.getExp());
            }
        }
        for (Monomial monomio : otro.p) {
            if (monomio != null) {
                resultado.insertar('+', monomio.getCoef(), monomio.getExp());
            }
        }
        return resultado;
    }

    public Polynomial restar(Polynomial otro) {
        Polynomial resultado = new Polynomial(this.p.length + otro.p.length);
        for (Monomial monomio : this.p) {
            if (monomio != null) {
                resultado.insertar('+', monomio.getCoef(), monomio.getExp());
            }
        }
        for (Monomial monomio : otro.p) {
            if (monomio != null) {
                resultado.insertar('-', monomio.getCoef(), monomio.getExp());
            }
        }
        return resultado;
    }

    public Polynomial multiplicar(Polynomial otro) {
        Polynomial resultado = new Polynomial(this.p.length * otro.p.length);
        for (Monomial monomioA : this.p) {
            if (monomioA != null) {
                for (Monomial monomioB : otro.p) {
                    if (monomioB != null) {
                        int nuevoCoef = monomioA.getCoef() * monomioB.getCoef();
                        int nuevoExp = monomioA.getExp() + monomioB.getExp();
                        resultado.insertar('+', nuevoCoef, nuevoExp);
                    }
                }
            }
        }
        return resultado;
    }
    
    public double evaluar(double x) {
        double resultado = 0.0;
        for (Monomial m : p) {
            if (m != null) {
                resultado += m.getCoef() * Math.pow(x, m.getExp());
            }
        }
        return resultado;
    }

    public Monomial obtenerMonomio(int exponente) {
        for (Monomial m : p) {
            if (m != null && m.getExp() == exponente) {
                return m;
            }
        }
        return null; // Retorna null si no se encuentra el monomio con el exponente dado.
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
