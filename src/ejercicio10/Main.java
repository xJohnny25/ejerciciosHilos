package ejercicio10;

import javax.print.attribute.HashDocAttributeSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
        * Preguntar nombre y edad a usaurio y guardar en un arrayList.
        * Meter simulacion de tiradas en un método.
        */

        Jugador jugador1 = new Jugador("Juan", 19);
        String[] valoresTirada = {"ESCUDO", "YELMO", "CASTILLO", "ESPADA"};
        String[] tiradasJugador = jugador1.getTiradas();
        int contadorCastillo = 0;
        int contador = 0;

        jugador1.pagarTirada();
        System.out.println(jugador1.getCartera());

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
//
//        try {
//            hilo1.join();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

        hilo2.start();

//        try {
//            hilo2.join();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        String primeraTirada = tiradasJugador[0];

        for (String tirada : tiradasJugador) {
            if ((tirada.equals("CASTILLO"))){
                contadorCastillo++;
            } else if (tirada.equals(primeraTirada)) {
                contador++;
            }
        }

        if (contadorCastillo == 3) {
            jugador1.sumarPremio(5);
        } else if(contadorCastillo == 2) {
            jugador1.sumarPremio(0.5);
        }

        if (contador == 3) {
            jugador1.sumarPremio(1);
        }

        System.out.println(jugador1.getCartera());
    }
}
