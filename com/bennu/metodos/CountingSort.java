package com.bennu.metodos;

import com.bennu.IOrdenador;

public class CountingSort implements IOrdenador {

    @Override
    public void ordenar(double[] lista) {

        if (lista.length == 0) {
            return;
        }

        // Convertir double a enteros
        int[] numeros = new int[lista.length];

        int minimo = (int) Math.round(lista[0] * 100);
        int maximo = minimo;

        for (int i = 0; i < lista.length; i++) {

            numeros[i] = (int) Math.round(lista[i] * 100);

            if (numeros[i] < minimo) {
                minimo = numeros[i];
            }

            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }

        // Crear arreglo de conteo
        int rango = maximo - minimo + 1;
        int[] contador = new int[rango];

        // Contar cada número
        for (int numero : numeros) {
            contador[numero - minimo]++;
        }

        // Reconstruir lista ordenada
        int posicion = 0;

        for (int i = 0; i < contador.length; i++) {

            while (contador[i] > 0) {

                numeros[posicion] = i + minimo;
                posicion++;

                contador[i]--;
            }
        }

        // Convertir nuevamente a double
        for (int i = 0; i < lista.length; i++) {
            lista[i] = numeros[i] / 100.0;
        }
    }
}