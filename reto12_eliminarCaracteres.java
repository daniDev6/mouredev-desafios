import java.util.*;

public class reto12_eliminarCaracteres {
    public static void main(String[] args) {
        /*
         * Crea una función que reciba dos cadenas como parámetro (str1, str2)
         * e imprima otras dos cadenas como salida (out1, out2).
         * - out1 contendrá todos los caracteres presentes en la str1 pero NO
         *   estén presentes en str2.
         * - out2 contendrá todos los caracteres presentes en la str2 pero NO
         *   estén presentes en str1.
         */
        String frase1="";
        String frase2="";
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Para terminar ingrese terminar en cualquier momento");
            System.out.println("Ingrese las palabras que desea comparar");
            System.out.println("Frase 1: ");
            frase1=sc.nextLine();
            if(frase1.equalsIgnoreCase("terminar")){
                break;
            }
            System.out.println("Frase 2: ");
            frase2=sc.nextLine();
            if(frase2.equalsIgnoreCase("terminar")){
                break;
            }
            buscarCaracteres(frase1,frase2).forEach(
                    (key,value)-> System.out.println( key + value));

        }















    }

    static Map<String,List<Character>> buscarCaracteres(String palabra1,String palabra2){
        Map<String,List<Character>> mapaRepetidas= new HashMap<>();
        mapaRepetidas.put("output 1: \""+palabra1+"\" no en \""+ palabra2 + "\" ", caracteresNoRepetidos(palabra1.toCharArray(),palabra2.toCharArray()));
        mapaRepetidas.put("output 2: \""+palabra2+"\" no en \""+ palabra1 + "\" ", caracteresNoRepetidos(palabra2.toCharArray(),palabra1.toCharArray()));
        return mapaRepetidas;


    }
    static List<Character> caracteresNoRepetidos(char[] frase,char[] comparar){
        List<Character> letrasNoRepetidas=new ArrayList<>();

        boolean condicion=false;
        for(int i=0;i<frase.length;i++){
            for(int j=0;j<comparar.length;j++){
                if(frase[i]==comparar[j]){
                    condicion=true;
                }
            }
            if(!condicion){
                if(frase[i]!=' '){
                    letrasNoRepetidas.add(frase[i]);
                }
            }
            condicion=false;
        }
        return letrasNoRepetidas;
    }
}
