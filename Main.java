import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Es un InputStream
        Scanner lector = new Scanner(System.in);
        Generador generador = new Generador();
        mostrarMenu();
        while(true){
            int opcion = lector.nextInt();
            switch (opcion) {
                case 0:
                    mostrarMenu();
                    break;
                case 1:
                    generador.crear_archivo();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Programa terminado");
                    return;
                default:
                    System.out.println("Digite una opcion válida");
                    lector.close();
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
        System.out.print("Seleccione una opción : ");
    }
}