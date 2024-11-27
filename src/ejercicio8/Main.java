package ejercicio8;

public class Main {
    static int x = 3, y = 5, z = 7;
    static int a, b, c, w;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            a = x + y; //8
            System.out.println(a);
        });

        Thread t2 = new Thread(() -> {
            b = z - 1; //6
            System.out.println(b);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread(() -> {
            c = a - b; //2
            System.out.println(c);
        });

        t3.start();

        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t4 = new Thread(() -> {
            w = c + 1; //3
            System.out.println(w);
        });

        t4.start();
    }
}
