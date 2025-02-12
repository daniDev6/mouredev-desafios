import java.util.Scanner;

public class reto17_enMayusculas {
    public static void main(String[] args) {
        /*
         * Crea una función que reciba un String de cualquier tipo y se encargue de
         * poner en mayúscula la primera letra de cada palabra.
         * - No se pueden utilizar operaciones del lenguaje que
         *   lo resuelvan directamente.
         * 03/02/2025
         */
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("Bienvenido a la conversion de camel case");
        boolean centinella = true;
        Scanner scanner=new Scanner(System.in);
        while(centinella){

            System.out.println("Ingrese una frase para continuar: ");
            System.out.println("(Si desea terminar ingrese salir)");
            String frase = scanner.nextLine();
            if(frase.equalsIgnoreCase("salir")){
                centinella=false;
                System.out.println("Gracias por usar la app");
            }else{
            System.out.println(camelCase(frase));
            }
        }


    }
    static String camelCase(String frase){
        if(frase.equalsIgnoreCase(" ") || frase==null){
            return null;
        }
        StringBuilder nuevaFrase=new StringBuilder();
        boolean convertirMayuscula =true;
        for(char letra :frase.toCharArray()){
            if(letra==' '){
                convertirMayuscula=true;
            }
                if(convertirMayuscula){
                    nuevaFrase.append(Character.toUpperCase(letra));
                    convertirMayuscula=false;
                }else{
                    nuevaFrase.append(Character.toLowerCase(letra));
                }

        }
        return nuevaFrase.toString();


    }
}
