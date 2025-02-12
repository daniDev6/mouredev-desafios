import java.sql.SQLOutput;
import java.util.Scanner;

public class reto13_esPalidromo {
    public static void main(String[] args) {
        /*
         * Escribe una función que reciba un texto y retorne verdadero o
         * falso (Boolean) según sean o no palíndromos.
         * Un Palíndromo es una palabra o expresión que es igual si se lee
         * de izquierda a derecha que de derecha a izquierda.
         * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
         * Ejemplo: Ana lleva al oso la avellana.
         */
        boolean centinella=true;
        Scanner sc=new Scanner(System.in);
        String frase="";
        while (centinella){
            System.out.println("-------------------------------Bienvenido a la app que verifica si una frase/palabra es palindromo--------------------------------");
            System.out.print("-------------------------------");
            System.out.print("(RECUERDE!! que un palindromo se lee igual de atras a adelante)");
            System.out.print("-------------------------------");
            System.out.println();
            System.out.print("-------------------------------");
            System.out.print("!!SI INGRESA TERMINAR EL PROGRAMA SE CERRARA!!");
            System.out.print("-------------------------------");
            System.out.println();
            System.out.println("Ingrese una palabra/frase a verificar: ");
            frase=sc.nextLine();
            if(frase.equalsIgnoreCase("Terminar")){
                System.out.println("Gracias por usar la app");
                centinella=false;
            }else{
                String msj= esPalindromo(frase)?"Es palindromo "+true:"No es palindromo "+false;
                System.out.println(msj);
                System.out.println("Para terminar ingrese la palabra \"terminar\"");
            }
        }

    }
    static boolean esPalindromo(String frase){
        String fraseSinEspacios="";
        for(char letra : frase.toCharArray()){
            if(letra!=' '){
                fraseSinEspacios+=letra;
            }
        }
        char[] fraseEnOrden=fraseSinEspacios.toCharArray();
        char[] fraseEnDesOrden=new char[fraseSinEspacios.length()];
        int j=0;
        for(int i=fraseEnOrden.length-1;i>=0;i--){
            fraseEnDesOrden[j]=fraseEnOrden[i];

            j++;
        }

        return String.valueOf(fraseEnOrden).equalsIgnoreCase(String.valueOf(fraseEnDesOrden));



    }
}
