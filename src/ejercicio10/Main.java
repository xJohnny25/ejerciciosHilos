package ejercicio10;

import javax.print.attribute.HashDocAttributeSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        String[] valoresTirada = {"ESCUDO", "YELMO", "CASTILLO", "ESPADA"};
        int contador = 0;

        listaJugadores.add(new Jugador("Juan", 18));
        listaJugadores.add(new Jugador("Kike", 17));

        listaJugadores.forEach((jugador) -> {
            if (jugador.getEdad() < 18 || jugador.getCartera() == 0){

                System.out.println("No puedes jugar");
            }
        });


        for (String str : valoresTirada) {
            if (str.equals("ESCUDO")){
                contador++;
            }

            if (contador == 3) {
                listaJugadores.get(0).setCartera(listaJugadores.get(0).getCartera() + 5);
            } else if (contador == 2) {
                listaJugadores.get(0).setCartera(listaJugadores.get(0).getCartera() + 1);
            }

            
        }

        Thread hilo1 = new Thread(() -> System.out.println(valoresTirada[(int) (Math.random() * valoresTirada.length)]));
        Thread hilo2 = new Thread(() -> System.out.println(valoresTirada[(int) (Math.random() * valoresTirada.length)]));
        Thread hilo3 = new Thread(() -> System.out.println(valoresTirada[(int) (Math.random() * valoresTirada.length)]));

        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}
