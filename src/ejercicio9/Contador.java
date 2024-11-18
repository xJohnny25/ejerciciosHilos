package ejercicio9;

public class Contador {
    private int contador = 0;
    private final Object lock = new Object();
    int n;

    public Contador(int n) {
        this.n = n;
    }

    public void incrementar() {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                contador++;
            }
        }
    }

    public void decrementar() {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                contador--;
            }
        }
    }

    public int getContador() {
        return contador;
    }
}
