import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class reto15_numeroAmstrons {
    public static void main(String[] args) {
        /*30/01/25
         * Escribe una función que calcule si un número dado es un número de Armstrong
         * (o también llamado narcisista).
         * Si no conoces qué es un número de Armstrong, debes buscar información
         * al respecto.
         *  A^3 + B^3 + C^3 = Total = ABC
         * A^2+B^2 = AB
         *
         * Total = ABC
         *
         */
        int numero = 153;
        String numeroString=String.valueOf(numero);
        System.out.println(esNumeroArmstrong(numero));
        List<Integer> listaNumerosArmstrong=new ArrayList<>();
        for(int i=1;i<100000;i++){
            if(esNumeroArmstrong(i)){
                listaNumerosArmstrong.add(i);
            }
        }
        listaNumerosArmstrong.stream().forEach(System.out::println);


    }
    static int potenciaNumero(int potencia, int numero){
        int resultado=numero;
        for(int i=1;i<potencia;i++){
            resultado=numero*resultado;
        }
        return resultado;
    }
    static boolean esNumeroArmstrong(int numero){
        String numeroString=String.valueOf(numero);
        int resultado=0;
        for(char num : numeroString.toCharArray()){
            resultado+=potenciaNumero(numeroString.length(),Integer.parseInt(String.valueOf(num)));
        }
        return resultado==numero;
    }
}
