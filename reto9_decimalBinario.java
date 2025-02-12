import java.util.InputMismatchException;
import java.util.Scanner;

public class reto9_decimalBinario {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //decimalBinario(22);
        while(true){
            System.out.println("Ingrese un numero para convertir a binario o\n Ingrese 0 parar salir" );
            int numero=-1;
            try {
                numero= sc.nextInt();
                sc.nextLine();
                if(numero==0){
                    System.out.println("Gracias por utilizar el conversor");
                    break;
                }
                System.out.println("Soy binario "+ decimalBinario(numero));
                System.out.println("Prueba de que funciona de beria ser: "+ numero + " efectivamente es "+ binarioDecimal(decimalBinario(numero)));

            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un entero");
                sc.nextLine();
            }
        }










    }
    static long decimalBinario(int numero){
        String binario="";
        int aux=-1;
        int dividir=numero;
        int resto;
        do{
            resto=dividir%2;
            dividir=dividir/2;
            binario+=String.valueOf(resto);

        }while (dividir!=0);
        char[] binarioReal=new char[binario.length()];
        int j =0;
        for(int i=binario.length()-1;i>=0;i--){
            binarioReal[j]=binario.charAt(i);
            j++;
        }

        return Long.parseLong(String.valueOf(binarioReal));






    }
    static long binarioDecimal(long binario){
        char[] binarioString = String.valueOf(binario).toCharArray();
        int[] potencias=new int[binarioString.length];

        potencias[potencias.length-1]=1;
        for(int i=potencias.length-2;i>=0;i--){
            potencias[i]=potencias[i+1]*2;

        }

        long suma = 0;
        for(int i=potencias.length-1;i>=0;i--){
            if(binarioString[i]=='1'){
                suma+=potencias[i];
            }
        }
        return suma;


    }







}
