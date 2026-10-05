package com.bennu.metodos;

import com.bennu.IOrdenador;

//Princio de Divide y Vencerás
public class QuickSort implements IOrdenador{

    @Override
    public void ordenar(double[] numeros) 
    {
        quicksort(numeros,0,numeros.length-1);
    }
    
    // Izquieda del pivote (menores) y derecha (mayores) --> recursividad
    public void quicksort(double[] arr,int inicio, int fin)
    {
        //Caso base
        if (inicio >= fin) return;

        //Quicksort
        double pivote = arr[fin];
        int menor_pivote = inicio-1; 
        for(int i=inicio;i<fin;i++)
        {
            if(arr[i] < pivote)
            {
                //intercambiar siguiente del menor_pivote (acumular menores)
                double temp = arr[menor_pivote +1];
                arr[menor_pivote+1] = arr[i];
                arr[i] = temp;
                menor_pivote++; 
            }
        }
        //Colocar pivote en su lugar
        double temp = arr[menor_pivote+1];
        arr[menor_pivote+1] = arr[fin];
        arr[fin] = temp;

        //Posicion del pivote
        int posicion_pivote = menor_pivote +1;

        //Ordenar ambos lados
        quicksort(arr,inicio,posicion_pivote - 1);
        quicksort(arr,posicion_pivote + 1,fin);
    }
}
