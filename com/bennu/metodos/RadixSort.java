package com.bennu.metodos;

import com.bennu.IOrdenador;

public class RadixSort implements IOrdenador {

    @Override
    public void ordenar(double[] lista) {

        if (lista.length == 0) {
            return;
        }

        // double a enteros, con su mínimo y máximo
        int[] numeros = new int[lista.length];

        int minimo = (int) Math.round(lista[0] * 100);
        int maximo = minimo;

        for (int i = 0; i < lista.length; i++) {
            numeros[i] = (int) Math.round(lista[i] * 100);
            if (numeros[i] < minimo) minimo = numeros[i];
            if (numeros[i] > maximo) maximo = numeros[i];
        }

        // Desplazar todo restando el mínimo para que no haya negativos
        for (int i = 0; i < numeros.length; i++) numeros[i] -= minimo;
        int maximoDesplazado = maximo - minimo;

        // Ordenar dígito por dígito, desde las unidades hacia la izquierda.
        // exp = 1 (unidades), 10 (decenas), 100 (centenas)
        for (int exp = 1; maximoDesplazado / exp > 0; exp *= 10) {
            countingSortPorDigito(numeros, exp);
        }

        // Deshacer el desplazamiento y volver a double
        for (int i = 0; i < lista.length; i++) {
            lista[i] = (numeros[i] + minimo) / 100.0;
        }
    }

    //Arreglo de 9 ya que los valores son entre [0-9]
    private void countingSortPorDigito(int[] numeros, int exp) {

        int[] salida = new int[numeros.length];
        int[] contador = new int[10]; 

        // Contar cuántas veces aparece cada dígito en esta posición
        for (int numero : numeros) {
            int digito = (numero / exp) % 10;
            contador[digito]++;
        }

        // Suma acumulativa
        for (int i = 1; i < 10; i++) {
            contador[i] += contador[i - 1];
        }

        for (int i = numeros.length - 1; i >= 0; i--) {
            int digito = (numeros[i] / exp) % 10;
            salida[contador[digito] - 1] = numeros[i];
            contador[digito]--;
        }

        // Copiar el resultado de esta pasada de vuelta al arreglo
        System.arraycopy(salida, 0, numeros, 0, numeros.length);
    }
}