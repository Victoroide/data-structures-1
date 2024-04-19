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
