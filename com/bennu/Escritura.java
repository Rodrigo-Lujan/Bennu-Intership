package com.bennu;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Escritura {

    private final String archivo;

    public Escritura(String archivo)
    {
        this.archivo = archivo;
    }

    public void escribir(double[] numeros){
        try(Formatter salida = new Formatter(archivo)) 
        {
            for(double num: numeros)
            {
                salida.format("%.2f%n", num);
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
