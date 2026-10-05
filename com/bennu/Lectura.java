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

    public int buscar(double numero) 
    {
        double[] lista = leer();
        for(int i=0;i<lista.length;i++)
        {
            if(lista[i] == numero)
            {
                return i;
            }
        }
        return -1;
    }

    public int busqueda_binaria(double numero)
    {
        double[] lista = leer();
        int inicio = 0, fin= lista.length-1;
        
        while(inicio <= fin){
            int pos_media = (inicio+fin)/2;
            if(lista[pos_media] == numero){
                return  pos_media;
            }
            else if(lista[pos_media] < numero){
                inicio = pos_media+1;
            }
            else {
                fin = pos_media -1;
            }
        }

        return -1;
    }

}
