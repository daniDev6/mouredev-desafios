import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class reto4_numeroprimo {
    public static void main(String[] args) {
        /*
         * Escribe un programa que se encargue de comprobar si un número es o no primo.
         * Hecho esto, imprime los números primos entre 1 y 100.
         */
        Scanner scInt=new Scanner(System.in);
        vectoresPrimo(100);
        int centinella =-1;
        while(centinella!=0){

            System.out.println("Ingrese un numero entero: ");
            int numero=1;
            numero=ingresarEntero();
            System.out.println("El numero es primo? "+esPrimo(numero));
            System.out.println("Desea terminar ingrese 0");
            centinella=ingresarEntero();
        }
    }

    static boolean esPrimo(int numero){
        for(int i=2;i<numero;i++){
            if(numero%i==0 && i!=1 && numero!=i){
                return false;
            }
        }
        return true;
    }
    static void vectoresPrimo(int numero){
        List<Integer> listaPrimos=new ArrayList<>();
        for(int i=2;i<numero;i++){
            if(esPrimo(i)){
                listaPrimos.add(i);
            }
        }
        listaPrimos.stream().forEach(System.out::println);
    }
    static int ingresarEntero(){
        int numero;
        Scanner scInt2=new Scanner(System.in);
        while(true){
            try{
                numero=scInt2.nextInt();
                scInt2.nextLine();
                break;
            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero entero");
                scInt2.nextLine();
            }
        }
        return numero;
    }
}
