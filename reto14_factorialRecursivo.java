import java.util.Scanner;

public class reto14_factorialRecursivo {
    public static void main(String[] args) {
        /*30/01/25
         * Escribe una función que calcule y retorne el factorial de un número dado
         * de forma recursiva.
            !5 =2*3*4*5
            *
         */
        System.out.println("Ingrese un numero");
        Scanner scanner=new Scanner(System.in);
        int numero=scanner.nextInt();
        factorial(numero);
        System.out.println(factorial(numero));

    }
    static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    };

}
