import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class reto8_contandoPalabras {
    public static void main(String[] args) {
        /*
         * Crea un programa que cuente cuantas veces se repite cada palabra
         * y que muestre el recuento final de todas ellas.
         * - Los signos de puntuación no forman parte de la palabra.
         * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
         * - No se pueden utilizar funciones propias del lenguaje que
         *   lo resuelvan automáticamente.
         */
        Scanner sc=new Scanner(System.in);
        String frase="";
        do{

            System.out.println("Ingrese una palabra");
            frase=sc.nextLine();
            if(!frase.equalsIgnoreCase("terminar")){
                contadorDePalabras(frase);
                System.out.println("Si desea terminar ingrese terminar");
            }else{
                System.out.println("Gracias por usar la app");
            }
        }while(!frase.equalsIgnoreCase("terminar"));




    }
    static void contadorDePalabras(String frase){
        char[] palabrasArray=frase.toLowerCase().toCharArray();
        Set<Character> palabras = new HashSet<>();

        for(int i=0;i<palabrasArray.length-1;i++){
            if(palabrasArray[i]!= ' '){
                palabras.add(palabrasArray[i]);
            }
        }
        int contador=0;
        for ( char pala : palabras){
            for(int i=0;i<palabrasArray.length;i++){
                if(pala==palabrasArray[i]){
                    contador++;
                }
            }
            System.out.println("hay "+ contador +" "+ pala );
            contador=0;
        }
    }
}
