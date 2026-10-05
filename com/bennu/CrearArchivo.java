package com.bennu;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CrearArchivo {

    //Un booleano si se orden para que la busqueda sea binaria o secuencial

    //objeto que puede enviar datos a distintas ubicacione
    private Formatter salida;
    private Scanner lectura;

    private void abrirArchivo()
    {
        try
        {
            salida = new Formatter("numeros.txt");
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }

    public void registrar_aleatorios(int cantidad)
    {
        abrirArchivo();
                
        while(cantidad>0)
        {
            double num = Math.random() * 100.0;
            salida.format("%.2f%n", num);
            cantidad--;
        }

        cerrarArchivo(); //del buffer al disco (numeros.txt)
    }

    private void cerrarArchivo()
    {
        if (salida != null)
            salida.close();
        if (lectura != null){
            lectura.close();
        }
    }

    private void leer_archivo()
    {
        try
        {
            lectura = new Scanner(Paths.get("numeros.txt"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void leerRegistros()
    {
        leer_archivo();

        while(lectura.hasNext())
        {
            System.out.format("%.2f%n",lectura.nextDouble());
        }

        cerrarArchivo();
    }

    // convierte ArrayList<Double> a double[] 
    private double[] toArray(ArrayList<Double> lista){
        double[] arr = new double[lista.size()];
        for(int i = 0; i < lista.size(); i++)
            arr[i] = lista.get(i);
        return arr;
    }

    // convierte double[] de vuelta a ArrayList<Double>
    private ArrayList<Double> toList(double[] arr){
        ArrayList<Double> lista = new ArrayList<>();
        for(double d : arr)
            lista.add(d);
        return lista;
    }

    public void ordenaArchivo(int metodo)
    {
        leer_archivo();
        ArrayList<Double> lista = new ArrayList<>();
        while(lectura.hasNext())
        {
            lista.add(lectura.nextDouble());
        }
        cerrarArchivo();

        long inicio = System.currentTimeMillis();
        String nombre = "";

        switch(metodo)
        {
            case 1:
                Collections.sort(lista);                 // TimSort
                nombre = "Java Sort";
                break;
            case 2:
                double[] arr2 = toArray(lista);
                Arrays.parallelSort(arr2);               // paralelo
                lista = toList(arr2);
                nombre = "Parallel sort";
                break;
            case 3:
                double[] arr3 = toArray(lista);
                Arrays.sort(arr3);                        // dual-pivot quicksort
                lista = toList(arr3);
                nombre = "Quick sort";
                break;
            case 4:
                //heapSort(lista);
                nombre = "Heap sort";
                break;
            case 5:
                //bubbleSort(lista);
                nombre = "Bubble sort";
                break;
            default:
                System.out.println("Método no válido");
                return;
        }

        long fin = System.currentTimeMillis();
        System.out.println(nombre + " execution time : " + (fin - inicio) + " ms");

        // escribir el resultado ordenado
        abrirArchivo();
        for(Double num : lista)
            salida.format("%.2f%n", num);
        cerrarArchivo();
    }

    public void buscarNumero(Double numero) 
    {
        leer_archivo(); int posicion = 1;

        while(lectura.hasNext())
        {
            if(numero == lectura.nextDouble()){
                System.out.println("Se encuentra en la posicion " + posicion);
                break;
            }
            else
            {
                posicion++;
            }
        }
        
        cerrarArchivo();
    }

}

