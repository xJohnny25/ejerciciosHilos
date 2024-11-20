package pizzeria;

public class Consumidor extends Thread {
    private final Buffer b;
    private final Object lock = new Object();
    private int tipo;

    Consumidor(Buffer b) {
        this.b = b;
        this.tipo = (int) (Math.random() * 3) + 1;
    }

    @Override
    public void run() {
        while (true) {
            switch (tipo) {
                case 1:
                    b.quitarPizza();
                    break;
                case 2:
                    b.quitarEnsalada();
                    break;
                case 3:
                    b.quitarPizza();
                    b.quitarEnsalada();
                    break;
                default:
                    System.out.println("Problema con el consumidor");
                    break;
            }
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
