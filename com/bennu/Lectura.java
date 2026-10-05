package com.bennu;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Lectura {
    
    private final String archivo;

    public Lectura(String archivo)
    {
        this.archivo = archivo;
    }

    public double[] leer()
    {
        ArrayList<Double> lista = new ArrayList<>();
        try (Scanner lectura = new Scanner(Paths.get(archivo))) 
        {
            while(lectura.hasNextDouble())
            {
                lista.add(lectura.nextDouble());
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return new double[0];
        }

        double[] arreglo = new double[lista.size()];
        for (int i = 0; i < lista.size(); i++) arreglo[i] = lista.get(i);
        return arreglo;

    }

    public int buscar(double pedirNumeroBusqueda) 
    {
        return 0;
    }

}
