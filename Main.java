import java.nio.file.Paths;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Es un InputStream
        Scanner lector = new Scanner(System.in);
        CrearArchivo creador = new CrearArchivo();
        mostrarMenu();
        while(true){
            System.out.print("Seleccione una opción : ");
            int opcion = lector.nextInt();
            switch (opcion) {
                case 0:
                    mostrarMenu();
                    break;
                case 1:
                    creador.registrar_aleatorios();
                    break;
                case 2:
                    creador.leerRegistros();
                    break;
                case 3:
                    int n_metodo = mostrarMetodos(lector);
                    creador.ordenaArchivo(n_metodo);
                    break;
                case 4:
                    creador.leerRegistros();
                    break;
                case 5:
                    System.out.print("¿Que numero desea buscar?: ");
                    Double numero = lector.nextDouble();
                    creador.buscarNumero(numero);
                    break;
                case 6:
                    System.out.println("Programa terminado");
                    //cerrar lector aca o ocmo manejar esto
                    return;
                default:
                    System.out.println("Digite una opcion válida");
                    break;
            }
        }

    }

    public static void mostrarMenu(){
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

    public static int mostrarMetodos(Scanner lector){
        System.out.println("");
        System.out.println("¿Que método de ordenamiento quiere utilizar? :");
        System.out.println("1 - Java Sort :");
        System.out.println("2 - Java ParallelSort :");
        System.out.println("3 - Java QuickSort :");
        System.out.println("4 - Java HeapSort :");
        System.out.println("5 - Java BubbleSort :");
        System.out.print("Seleccione : ");
        return lector.nextInt();
    }
}