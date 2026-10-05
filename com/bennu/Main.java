package com.bennu;

import com.bennu.metodos.ArraysSort;
import com.bennu.metodos.QuickSort;

public class Main{
    
    private static final String ARCHIVO_NUMEROS = "numeros.txt";
    private static final String ARCHIVO_ORDENADO = "ordenados.txt";

    public static void main(String[] args){
        Menu menu = new Menu();
        Escritura escritorNumeros  = new Escritura(ARCHIVO_NUMEROS);
        Escritura escritorOrdenado = new Escritura(ARCHIVO_ORDENADO);
        Lectura   lectorNumeros    = new Lectura(ARCHIVO_NUMEROS);
        Lectura   lectorOrdenado   = new Lectura(ARCHIVO_ORDENADO);
        Generador generador = new Generador();

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
                    escritorNumeros.escribir(generador.generar(cantidad));
                    break;
                case 2:
                    imprimir(lectorNumeros.leer());
                    break;
                case 3:
                    int metodoElegido = menu.pedirMetodo();
                    IOrdenador estrategia = obtenerEstrategia(metodoElegido);
                    if (estrategia == null) {
                        System.out.println("Método no válido");
                        break;
                    }
                    double[] numeros = lectorNumeros.leer();
                    long inicio = System.currentTimeMillis();
                    estrategia.ordenar(numeros);
                    long fin = System.currentTimeMillis();
                    System.out.println("Tiempo de ejecución : " + (fin - inicio) + " ms");
                    escritorOrdenado.escribir(numeros);
                    break;
                case 4:
                    imprimir(lectorOrdenado.leer());
                    break;
                case 5:
                    int posicion = lectorOrdenado.busqueda_binaria(menu.pedirNumeroBusqueda());
                    System.out.println("Ubicado en posicion: " + posicion);
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

    private static IOrdenador obtenerEstrategia(int metodo) 
    {
        switch (metodo) 
        {
            case 1: 
                return new ArraysSort();
            case 2: 
                return new QuickSort();
            default: 
                return null;
        }
    }

}