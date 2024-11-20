package ejercicio11;

public class Mensajero {
    private final Object lock = new Object();
    private String mensaje;

    public void almacenarMensajes(String mensajeNuevo) {
        synchronized (lock) {
            mensaje = mensajeNuevo;
            System.out.println("Mensaje escrito: " + mensaje);
        }
    }

    public void imprimirMensaje() {
        synchronized (lock) {
            if (mensaje != null) {
                System.out.println("Mensaje leído: " + mensaje);
            } else {
                System.out.println("No hay ningún mensaje");
            }
        }
    }
}
