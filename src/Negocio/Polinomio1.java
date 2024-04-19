package Negocio;

import java.util.Arrays;
import java.util.Comparator;

public class Polinomio1 {
    private Monomio[] p;
    private int dim;

    public Polinomio1(int capacidad) {
        p = new Monomio[capacidad];
        dim = -1;
    }

    public void insertar(char signo, int coef, int exp) {
        if (coef == 0) return;
        Monomio nuevo = new Monomio(signo, coef, exp);
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
        Arrays.sort(p, 0, dim + 1, new Comparator<Monomio>() {
            @Override
            public int compare(Monomio m1, Monomio m2) {
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
    
    public Polinomio1 sumar(Polinomio1 otro) {
        Polinomio1 resultado = new Polinomio1(this.p.length + otro.p.length);
        for (Monomio monomio : this.p) {
            if (monomio != null) {
                resultado.insertar('+', monomio.getCoef(), monomio.getExp());
            }
        }
        for (Monomio monomio : otro.p) {
            if (monomio != null) {
                resultado.insertar('+', monomio.getCoef(), monomio.getExp());
            }
        }
        return resultado;
    }

    public Polinomio1 restar(Polinomio1 otro) {
        Polinomio1 resultado = new Polinomio1(this.p.length + otro.p.length);
        for (Monomio monomio : this.p) {
            if (monomio != null) {
                resultado.insertar('+', monomio.getCoef(), monomio.getExp());
            }
        }
        for (Monomio monomio : otro.p) {
            if (monomio != null) {
                resultado.insertar('-', monomio.getCoef(), monomio.getExp());
            }
        }
        return resultado;
    }

    public Polinomio1 multiplicar(Polinomio1 otro) {
        Polinomio1 resultado = new Polinomio1(this.p.length * otro.p.length);
        for (Monomio monomioA : this.p) {
            if (monomioA != null) {
                for (Monomio monomioB : otro.p) {
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
        for (Monomio m : p) {
            if (m != null) {
                resultado += m.getCoef() * Math.pow(x, m.getExp());
            }
        }
        return resultado;
    }

    public Monomio obtenerMonomio(int exponente) {
        for (Monomio m : p) {
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
