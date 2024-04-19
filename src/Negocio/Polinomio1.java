package Negocio;

public class Polinomio1 {
    private Monomio[] p;
    private int dim;

    public Polinomio1(int cant) {
        this.p = new Monomio[cant];
        this.dim = -1;
    }

    private void redimensionar() {
        Monomio[] nuevo = new Monomio[this.p.length + 5];
        System.arraycopy(this.p, 0, nuevo, 0, this.p.length);
        this.p = nuevo;
    }

    public void insertar(char signo, int coef, int exp) {
        Monomio nuevo = new Monomio(signo, coef, exp);
        if (dim == -1) {
            p[++dim] = nuevo;
            return;
        }

        for (int i = 0; i <= dim; i++) {
            if (p[i].getExp() == exp) {
                p[i].sumar(nuevo);
                if (p[i].getCoef() == 0) {
                    eliminar(exp);
                }
                return;
            }
            if (p[i].getExp() < exp) {
                if (dim + 1 == p.length) {
                    redimensionar();
                }
                System.arraycopy(p, i, p, i + 1, dim - i + 1);
                p[i] = nuevo;
                dim++;
                return;
            }
        }

        if (dim + 1 == p.length) {
            redimensionar();
        }
        p[++dim] = nuevo;
    }

    public void eliminar(int exp) {
        for (int i = 0; i <= dim; i++) {
            if (p[i].getExp() == exp) {
                System.arraycopy(p, i + 1, p, i, dim - i);
                dim--;
                return;
            }
        }
    }

    @Override
    public String toString() {
        if (dim == -1) return "P(x)=0";
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= dim; i++) {
            if (i == 0) {
                s.append(p[i].toString().replaceFirst("^\\+", ""));
            } else {
                s.append(p[i].toString());
            }
        }
        return "P(x)=" + s.toString();
    }
}
