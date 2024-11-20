package ejercicio11;

public class Main {
    public static void main(String[] args) {
        Mensajero mensajero = new Mensajero();

        Thread t1 = new Thread(() -> mensajero.almacenarMensajes("adios"));
        Thread t2 = new Thread(mensajero::imprimirMensaje);

        t1.start();
        t2.start();
    }
}