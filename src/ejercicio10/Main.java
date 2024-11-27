package ejercicio10;

import org.w3c.dom.ls.LSOutput;

import javax.print.attribute.HashDocAttributeSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void jugar(Jugador jugador) {
        String[] tiradasJugador = jugador.getTiradas();
        String[] valoresTirada = {"ESCUDO", "YELMO", "CASTILLO", "ESPADA"};
        Scanner sc = new Scanner(System.in);
        double carteraUsuario = jugador.getCartera();
        int precioTirada = 10;
        int contadorCastillo;
        int contador;
        int opcion;

        do {
            contadorCastillo = 0;
            contador = 0;

            System.out.println("Para jugar pulse 1, para salir pulse 2.");
            opcion = sc.nextInt();

            if (opcion == 1 && jugador.getCartera() > precioTirada) {
                jugador.pagarTirada(precioTirada);
                System.out.println(jugador.getCartera());

                Thread hilo1 = new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tiradasJugador[0] = valoresTirada[(int) (Math.random() * valoresTirada.length)];
                    System.out.println("PRIMERA TIRADA: " + tiradasJugador[0]);
                });
                Thread hilo2 = new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tiradasJugador[1] = valoresTirada[(int) (Math.random() * valoresTirada.length)];
                    System.out.println("SEGUNDA TIRADA: " + tiradasJugador[1]);
                });
                Thread hilo3 = new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tiradasJugador[2] = valoresTirada[(int) (Math.random() * valoresTirada.length)];
                    System.out.println("TERCERA TIRADA: " + tiradasJugador[2]);
                });

                hilo1.start();
                hilo2.start();
                hilo3.start();

                try {
                    hilo1.join();
                    hilo2.join();
                    hilo3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String primeraTirada = tiradasJugador[0];

                for (String tirada : tiradasJugador) {
                    if ((tirada.equals("CASTILLO"))) {
                        contadorCastillo++;
                    } else if (tirada.equals(primeraTirada)) {
                        contador++;
                    }
                }

                if (contadorCastillo == 3) {
                    jugador.sumarPremio(5);
                } else if (contadorCastillo == 2) {
                    jugador.sumarPremio(0.5);
                }

                if (contador == 3) {
                    jugador.sumarPremio(1);
                }

                System.out.println(jugador.getCartera());
            } else {
                if (jugador.getCartera() < precioTirada) {
                    System.out.println("No tienes fondos suficientes para seguir jugando.");
                } else {
                    System.out.println("Gracias por jugar con nosotros!");
                }

            }
        } while (opcion != 2);
    }

    public static void main(String[] args) {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(new Jugador("Juan", 19));
        listaJugadores.add(new Jugador("pedro", 24));
        listaJugadores.add(new Jugador("jorge", 63));

        Scanner sc = new Scanner(System.in);
        String nombreUsuario;
        int edadUsuario;

        System.out.println("Introduzca su nombre: ");
        nombreUsuario = sc.nextLine();

        System.out.println("Introduzca su edad");
        edadUsuario = sc.nextInt();

        if (edadUsuario < 18) {
            System.out.println("Necesitas tener al menos 18 años para jugar.");
        } else {
            listaJugadores.add((new Jugador(nombreUsuario, edadUsuario)));
            for (Jugador jugador : listaJugadores) {
                if (jugador.getNombre().equals(nombreUsuario) && jugador.getEdad() == edadUsuario) {
                    System.out.println("Bienvenido " + jugador.getNombre());
                    Main.jugar(jugador);
                }
            }
        }
    }
}
