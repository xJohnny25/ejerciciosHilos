package pizzeria;

public class Productor extends Thread {
    private final Buffer b;


    Productor(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        int valor;

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            valor = (int) (Math.random() * 21);

            if (valor <= 14) {
                b.ponerPizza();
            } else {
                b.ponerEnsalada();
            }
        }
    }
}
