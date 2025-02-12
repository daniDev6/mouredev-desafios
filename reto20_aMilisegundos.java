import java.util.Scanner;

public class reto20_aMilisegundos {
    public static void main(String[] args) {
        /*
         * Crea una función que reciba días, horas, minutos y segundos (como enteros)
         * y retorne su resultado en milisegundos.
         */
        Scanner sc=new Scanner(System.in);

        System.out.println("Ingrese la cantidad de dias");
        int dias= sc.nextInt();
        System.out.println("Ingrese la cantidad de horas");
        int horas= sc.nextInt();
        System.out.println("Ingrese la cantidad de minutos");
        int minutos= sc.nextInt();
        System.out.println("Ingrese la cantidad de segundos");
        int segundos= sc.nextInt();
        System.out.println("En milisegundos son: " + aMilisegundos(dias,horas,minutos,segundos));
       Prueba<String> prueba1=new Prueba<>();
       Prueba<Integer> prueba2=new Prueba<>();
       prueba1.ingrese("Hola mundo");
       prueba2.ingrese(123);


    }
    static long aMilisegundos(int dias,int horas,int minutos,int segundos){
        return (dias*24*60*60*1000 +horas*60*60*1000+minutos*60*1000+segundos*1000 );
    }

}
class Prueba<T>{
    public T ingrese(T t){
        if(t instanceof String){
            System.out.println("Soy un string");
            return t;
        } else if (t instanceof Integer) {
            System.out.println("Soy un entero");
            return t;
        }else{
            System.out.println("No soy ni string ni entero");
            return t;
        }
    }
}