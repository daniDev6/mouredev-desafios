import java.util.InputMismatchException;
import java.util.Scanner;

public class reto2_anagrama {
    public static void main(String[] args) {
        /*
        #2
¿ES UN ANAGRAMA?
        /*
         * Escribe una función que reciba dos palabras (String) y retorne
         * verdadero o falso (Bool) según sean o no anagramas.
         * - Un Anagrama consiste en formar una palabra reordenando TODAS
         *   las letras de otra palabra inicial.
         * - NO hace falta comprobar que ambas palabras existan.
         * - Dos palabras exactamente iguales no son anagrama.
         */
        String palabra=" ";
        System.out.println(palabra.isBlank());
        int centinella=-1;
        while(centinella!=0){

            Scanner sc=new Scanner(System.in);
            Scanner scInt=new Scanner(System.in);
            System.out.println("Ingrese la primer palabra");
            String palabra1=sc.next();
            System.out.println("Ingrese la segunda palabra");
            String palabra2=sc.next();
            System.out.println("es anagrama? " +evaluar(palabra1,palabra2));
            while(true){

            System.out.println("Si Desea terminar ingrese 0");
            try{
                centinella=scInt.nextInt();
                scInt.nextLine();
                break;
            }catch (InputMismatchException e){
                scInt.nextLine();
                break;
            }
            }

        }


    }
    public static boolean evaluar(String palabra1,String palabra2){
        if(palabra2.equalsIgnoreCase(palabra1)){
            return false;
        }
        char[] letras1 = palabra1.toCharArray();
        char[] letras2 = palabra2.toCharArray();

        for(int i=0;i<letras1.length;i++){
            for(int j=0;j<letras2.length;j++){
                if(letras1[i]==letras2[j]){
                    letras2[j]=' ';
                }
            }
        }
        if(String.valueOf(letras2).isBlank()){
            return true;
        }else{
            return false;
        }







    }
}
