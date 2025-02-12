import java.util.Scanner;

public class reto7_invirtiendoCadena {
    public static void main(String[] args) {
        System.out.println("Ingrese una frase o palabra");
        Scanner scanner=new Scanner(System.in);
        String frase=scanner.nextLine();
        String invertida=invertir(frase);
        System.out.println(invertida);

    }
    static String invertir(String frase){
        char[] arrayChar = new char[frase.length()];
        char[] arrayChar2 = frase.toCharArray();
        int j=0;
        for(int i=frase.length()-1;i>=0;i--){
            arrayChar[j]=arrayChar2[i];
            j++;
        }
        return String.valueOf(arrayChar);
    }
}
