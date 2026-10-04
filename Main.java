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
                    creador.ordenaArchivo();
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
                    System.exit(0);
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
}