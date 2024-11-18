package ejercicio10;

public class Jugador {
    private String nombre;
    private int edad;
    private double cartera = 25;
    private String[] tiradas;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        tiradas = new String[3];
    }

    public String getNombre() {
        return nombre;
    }

    public double getCartera() {
        return cartera;
    }

    public int getEdad() {
        return edad;
    }

    public void setCartera(double cartera) {
        this.cartera = cartera;
    }
}
