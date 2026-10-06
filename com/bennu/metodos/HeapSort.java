package com.bennu.metodos;

import com.bennu.IOrdenador;

public class HeapSort implements IOrdenador{

     @Override
    public void ordenar(double[] lista) {
 
        int n = lista.length;
 
        // el max-heap.
        for (int i = n / 2 - 1; i >= 0; i--) {
            hundir(lista, i, n);
        }
 
        for (int fin = n - 1; fin > 0; fin--) {
 
            double temp = lista[0];
            lista[0] = lista[fin];
            lista[fin] = temp;
 
            hundir(lista, 0, fin);
        }
    }

    private void hundir(double[] lista, int i, int n) {
 
        while (true) {
 
            int mayor = i;
            int hijoIzq = 2 * i + 1;
            int hijoDer = 2 * i + 2;
 
            // Solo comparamos con los hijos que existan (validar límites)
            if (hijoIzq < n && lista[hijoIzq] > lista[mayor]) {
                mayor = hijoIzq;
            }
            if (hijoDer < n && lista[hijoDer] > lista[mayor]) {
                mayor = hijoDer;
            }
 
            // Si el nodo ya es el mayor de los tres, terminamos
            if (mayor == i) {
                return;
            }
 
            // Intercambiar con el hijo mayor y seguir hundiendo hacia ese subárbol
            double temp = lista[i];
            lista[i] = lista[mayor];
            lista[mayor] = temp;
 
            i = mayor;
        }
    }
    
}
