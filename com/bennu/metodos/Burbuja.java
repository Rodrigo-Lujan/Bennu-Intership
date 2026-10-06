package com.bennu.metodos;

import com.bennu.IOrdenador;

public class Burbuja implements IOrdenador{

    //Hasta no necesitar intercambios
    //Dejar mayor al final
    @Override
    public void ordenar(double[] lista) {
        boolean huboIntercambio = false;
        for(int i=lista.length-1;i>0;i--){
            for(int j=0;j<i;j++)
            {
                //Intercambiar (dejar mayor al final)
                if(lista[j]>lista[j+1]){
                    double temp = lista[j];
                    lista[j] = lista[j+1];
                    lista[j+1] = temp;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break; // ya está ordenado
            }
        }
    }
    
}
