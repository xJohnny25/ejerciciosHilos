package ejercicio9;

public class Main {
    private static int n = (int) (Math.random() * 5);
    private static int m = (int) (Math.random() * 5);
    private static Contador contador = new Contador(n);

    public static void crearHilos(int m){
        Thread[] incrementadores = new Thread[m];
        Thread[] decrementadores = new Thread[m];

        for (int i = 0; i < m; i++) {
            incrementadores[i] = new Thread(() -> contador.incrementar());
            incrementadores[i].start();
        }

        for (int i = 0; i < m; i++) {
            decrementadores[i] = new Thread(() -> contador.decrementar());
            decrementadores[i].start();
        }

        try {
            for (int i = 0; i < m; i++) {
                incrementadores[i].join();
                decrementadores[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        crearHilos(m);
        System.out.println(contador.getContador());
    }
}
