import java.util.ArrayList;
import java.util.List;

public abstract class Motor {
    public List<Double> lista;
    public Motor(){
        lista = new ArrayList<>();
    }

    public void leer_numeros(){
        long inicio = System.nanoTime();
        lista.add(2.0);
        lista.add(32.1);
        long fin = System.currentTimeMillis();
        long tiempo_mil = (inicio-fin) / 1_000_000;
        System.out.println("Tiempo de lectura de archivo: " + tiempo_mil + " mil.");
    }
}

