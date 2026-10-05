package com.bennu;
import java.util.Scanner;

import com.bennu.metodos.ArraysSort;
import com.bennu.metodos.QuickSort;

public class Main{

    private static Menu menu = new Menu();
    private static Escritura escritor = new Escritura();
    private static Lectura lector = new Lectura();
    private static Generador generador = new Generador();
    
    public static void main(String[] args){

        menu.mostrar();
        boolean salir = false;

        while (!salir) {
            int opcion = menu.pedirOpcion();
            switch (opcion) {
                case 0:
                    menu.mostrar();
                    break;
                case 1:
                    int cantidad = menu.pedirCantidad();
                    escritor.escribir(generador.generar(cantidad));
                    break;
                case 2:
                case 4:
                    imprimir(lector.leer());
                    break;
                case 3:
                    int metodo = menu.pedirMetodo();
                    //preguntar por el metodo
                    ordenarArchivo(metodo);
                    break;
                case 5:
                    buscar(menu.pedirNumeroBusqueda());
                    break;
                case 6:
                    System.out.println("Programa terminado");
                    menu.cerrar();
                    salir = true;
                    break;
                default:
                    System.out.println("Digite una opcion válida");
            }
        }
    }

    private static void imprimir(double[] numeros) 
    {
        for (double num : numeros) 
            {
            System.out.format("%.2f%n", num);
        }
    }

    private static void ordenarArchivo(int metodo) 
    {
        double[] numeros = lector.leer();
        IOrdenador estrategia; //Interfaz que implementa metodo ordenar()

        switch (metodo) 
        {
            case 1: 
                estrategia = new ArraysSort(); 
                break;
            case 2: 
                estrategia = new QuickSort(); 
                break;
            default:
                System.out.println("Método no válido");
                return;
        }

        long inicio = System.currentTimeMillis();
        
        //pasarle los numeros en double[]
        estrategia.ordenar(numeros);
        
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución : " + (fin - inicio) + " ms");

        escritor.escribir(numeros);
    }

    private static void buscar(double numero) 
    {
        //Hacer busqueda binaria en archivo ordenado

        //Hacer busqueda secuencial si no se ha ordenado
        
        System.out.println("No se encontró el número");
    }

}