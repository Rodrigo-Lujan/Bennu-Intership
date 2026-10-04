import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class CrearArchivo {

    //Un booleano si se orden para que la busqueda sea binaria o secuencial

    //objeto que puede enviar datos a distintas ubicacione
    private Formatter salida;
    private Scanner lectura;

    private void abrirArchivo()
    {
        try
        {
            salida = new Formatter("numeros.txt");
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }

    public void registrar_aleatorios()
    {
        abrirArchivo();
        
        int n=4; double max=50,min=-100;   
        if(max<min) return;
        
        while(n>0)
        {
            double num = Math.round(Math.random() * 100.0) / 100.0;
            salida.format("%.2f%n", num);
            n--;
        }

        cerrarArchivo(); //del buffer al disco (numeros.txt)
    }

    private void cerrarArchivo()
    {
        if (salida != null)
            salida.close();
        if (lectura != null){
            lectura.close();
        }
    }

    private void leer_archivo()
    {
        try
        {
            lectura = new Scanner(Paths.get("numeros.txt"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void leerRegistros()
    {
        leer_archivo();

        while(lectura.hasNext())
        {
            System.out.format("%.2f%n",lectura.nextDouble());
        }

        cerrarArchivo();
    }

    public void ordenaArchivo()
    {
        leer_archivo();
        ArrayList<Double> lista = new ArrayList<>();

        while(lectura.hasNext())
        {
            lista.add(lectura.nextDouble());
        }

        cerrarArchivo();

        //PONER EN numeros_ordenados.txt
        Collections.sort(lista);

        abrirArchivo();       // reabre "numeros.txt" con el Formatter (lo sobrescribe)

        for(Double num : lista)
        {
            salida.format("%.2f%n", num);   // mismo formato que usas al registrar
        }

        cerrarArchivo();      

    }

    public void buscarNumero(Double numero) 
    {
        leer_archivo(); int posicion = 1;

        while(lectura.hasNext())
        {
            if(numero == lectura.nextDouble()){
                System.out.println("Se encuentra en la posicion " + posicion);
                break;
            }
            else
            {
                posicion++;
            }
        }   
    }
}

