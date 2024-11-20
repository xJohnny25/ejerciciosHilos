package pizzeria;

public class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer();

        Productor cocinero = new Productor(b);
        cocinero.start();

        Consumidor consumidor1 = new Consumidor(b);
        Consumidor consumidor2 = new Consumidor(b);
        Consumidor consumidor3 = new Consumidor(b);
        Consumidor consumidor4 = new Consumidor(b);
        Consumidor consumidor5 = new Consumidor(b);
        Consumidor consumidor6 = new Consumidor(b);

        consumidor1.start();
        consumidor2.start();
        consumidor3.start();
        consumidor4.start();
        consumidor5.start();
        consumidor6.start();
    }
}
