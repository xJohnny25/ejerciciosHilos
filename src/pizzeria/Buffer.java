package pizzeria;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Buffer {
    private final LinkedList<Integer> listaPizzas = new LinkedList<>();
    private final LinkedList<Integer> listaEnsaladas = new LinkedList<>();

    private final int maxPizzas = 10;
    private final int maxEnsaladas = 5;

    private final AtomicInteger numPizzas = new AtomicInteger(0);
    private final AtomicInteger numEnsaladas = new AtomicInteger(0);

    synchronized void ponerPizza() {
        if (numPizzas.get() < maxPizzas) {
            numPizzas.incrementAndGet();
            System.out.println("AÑADIMOS UNA PIZZA, TENEMOS: " + numPizzas.get());
        }
    }

    synchronized void ponerEnsalada() {
        if (numEnsaladas.get() < maxEnsaladas) {
            numEnsaladas.incrementAndGet();
            System.out.println("AÑADIMOS UNA ENSALADA, TENEMOS: " + numEnsaladas.get());
        }
    }

    synchronized void quitarPizza() {
        if (numPizzas.get() > 0) {
            numPizzas.decrementAndGet();
            System.out.println("PIZZA ENTREGADA, NOS QUEDAN: " + numPizzas.get());
        }
    }

    synchronized void quitarEnsalada() {
        if (numEnsaladas.get() > 0) {
            numEnsaladas.decrementAndGet();
            System.out.println("ENSALADA ENTREGADA, NOS QUEDAN: " + numEnsaladas.get());
        }
    }
}
