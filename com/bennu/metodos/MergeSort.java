package com.bennu.metodos;

import com.bennu.IOrdenador;

public class MergeSort implements IOrdenador {

    @Override
    public void ordenar(double[] lista) {
        ordenar(lista, 0, lista.length - 1);
    }

    private void ordenar(double[] lista, int inicio, int fin) {

        // Caso base
        if (inicio >= fin) return;

        // Punto medio
        int medio = (inicio + fin) / 2;

        // Dividir
        ordenar(lista, inicio, medio);
        ordenar(lista, medio + 1, fin);

        // Combinar
        mezclar(lista, inicio, medio, fin);
    }

    private void mezclar(double[] lista, int inicio, int medio, int fin) {

        double[] auxiliar = new double[fin - inicio + 1];

        int izquierda = inicio;
        int derecha = medio + 1;
        int posicion = 0;

        // Comparar ambas mitades
        while (izquierda <= medio && derecha <= fin) {

            if (lista[izquierda] <= lista[derecha]) {
                auxiliar[posicion++] = lista[izquierda++];
            } else {
                auxiliar[posicion++] = lista[derecha++];
            }
        }

        // Copiar elementos restantes de la izquierda
        while (izquierda <= medio) {
            auxiliar[posicion++] = lista[izquierda++];
        }

        // Copiar elementos restantes de la derecha
        while (derecha <= fin) {
            auxiliar[posicion++] = lista[derecha++];
        }

        // Pasar resultado al arreglo original
        for (int i = 0; i < auxiliar.length; i++) {
            lista[inicio + i] = auxiliar[i];
        }
    }
}