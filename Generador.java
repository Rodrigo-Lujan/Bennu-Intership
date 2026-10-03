public class Generador {
    public void crear_archivo(){
        int n=4; double max=50,min=-100;
        if(max<min) return;
        while(n>0){
            double num = Math.round(Math.random() * 100.0) / 100.0;
            System.out.println("Numero: " + num);
            n--;
        }
    }
}
