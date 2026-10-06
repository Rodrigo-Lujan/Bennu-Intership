package com.bennu.metodos;

import com.bennu.IOrdenador;

public class Seleccion implements IOrdenador{

    @Override
    public void ordenar(double[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {

            int posMin = i;

            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[posMin]) {
                    posMin = j;
                }
            }

            if (posMin != i) {
                double temp = lista[i];
                lista[i] = lista[posMin];
                lista[posMin] = temp;
            }
        }
    }
    
}
