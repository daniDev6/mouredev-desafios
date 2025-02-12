import java.util.Scanner;

public class reto21_parandoElTiempo {
    public static void main(String[] args) {
        /*
         * Crea una función que sume 2 números y retorne su resultado pasados
         * unos segundos.
         * - Recibirá por parámetros los 2 números a sumar y los segundos que
         *   debe tardar en finalizar su ejecución.
         * - Si el lenguaje lo soporta, deberá retornar el resultado de forma
         *   asíncrona, es decir, sin detener la ejecución del programa principal.
         *   Se podría ejecutar varias veces al mismo tiempo.
         */
        Hilos nHilo=new Hilos();
        nHilo.run();

    }


}
class Hilos implements Runnable{

    static int sumar(int n1,int n2){
        try{
        Thread.sleep((n1+n2)*1000 );
        }catch (InterruptedException e){
            new RuntimeException(e);
        }
        return n1+n2;
    }
    int ingresarEntero(){
        Scanner scanner= new Scanner(System.in);
        int numero=0;
        while (true){
            try{
                numero=scanner.nextInt();
                scanner.nextLine();
                break;
            }catch (NumberFormatException e){
                System.out.println("Debe ser un entero");
                new RuntimeException(e);
                scanner.nextLine();
            }
        }
        return numero;
    }
    @Override
    public void run() {
        System.out.println("Ingrese el primer numero: ");
        int n1= ingresarEntero();
        System.out.println("Ingrese el segundo numero: ");
        int n2=ingresarEntero();
        System.out.println("La suma es: " + sumar(n1,n2));
    }
}
