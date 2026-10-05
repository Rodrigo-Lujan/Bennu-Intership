package com.bennu;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Escritura {

    public void escribir(double[] numeros){
        try(Formatter salida = new Formatter("numeros.txt")) 
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
