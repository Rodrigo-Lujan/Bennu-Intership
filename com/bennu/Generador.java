package com.bennu;

public class Generador {
    
    public double[] generar(int cantidad)
    {     
        double[] numeros = new double[cantidad];
        for(int i=0;i<cantidad;i++)
        {
            numeros[i] = Math.random() * 100.0;
        }
        return numeros;
    }

}
