package com.bennu;

import java.util.Scanner;

public class Menu {
    //lector del teclado mediante objeto InputStream
    private Scanner lector = new Scanner(System.in);

    public void mostrar() 
    {
        System.out.println("Opciones");
        System.out.println("--------------------");
        System.out.println("0 - Menu");
        System.out.println("1 - Genera nuevo archivo");
        System.out.println("2 - Lee archivo generado");
        System.out.println("3 - Ordena archivo");
        System.out.println("4 - Lee archivo ordenado");
        System.out.println("5 - Buscar numero en archivo");
        System.out.println("6 - Salir");
    }

    public int pedirOpcion() 
    {
        System.out.print("Seleccione una opción : ");
        
        while (!lector.hasNextInt()) {
            System.out.println("Digite un número válido");
            lector.next();
            System.out.print("Seleccione una opción : ");
        }
        
        return lector.nextInt();
    }

    public int pedirCantidad() 
    {
        System.out.print("¿Cuantos numeros desea generar?: ");
        
        return lector.nextInt();
    }

    public int pedirMetodo() 
    {
        System.out.println();
        System.out.println("¿Que método de ordenamiento quiere utilizar? :");
        System.out.println("1 - Java Sort (Arrays.sort)");
        System.out.println("2 - QuickSort");
        System.out.println("3 - RadixSort");
        System.out.println("4 - MergeSort");
        System.out.println("5 - HeapSort");
        System.out.println("6 - Burbuja");
        System.out.println("7 - Selección");
        System.out.print("Seleccione : ");
        
        return lector.nextInt();
    }

    public double pedirNumeroBusqueda() 
    {
        System.out.print("¿Que numero desea buscar?: ");
        
        return lector.nextDouble();
    }

    public void cerrar() 
    {
        lector.close();
    }

}
