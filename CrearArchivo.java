import java.util.Formatter;

public class CrearArchivo {

    //objeto que puede enviar datos a distintas ubicacione
    private Formatter salida;

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

    public void cerrarArchivo()
    {
        if (salida != null)
            salida.close();
    }

    public void leer_archivo()
    {
        
    }

}
