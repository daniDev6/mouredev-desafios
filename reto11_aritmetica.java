public class reto11_aritmetica {
    public static void main(String[] args) {
        /*
         * Crea un programa que comprueba si los paréntesis, llaves y corchetes
         * de una expresión están equilibrados.
         * - Equilibrado significa que estos delimitadores se abren y cieran
         *   en orden y de forma correcta.
         * - Paréntesis, llaves y corchetes son igual de prioritarios.
         *   No hay uno más importante que otro.
         * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
         * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
         */
       // System.out.println(estaLaLetra("{ [ a * ( c + d ) ] - 5 }",'{'));
        //String ecuacion = "{ [ a * ( c + d ) ] - 5 }";
        String ecuacionN = "{[a+b*(a-b])}";

        System.out.println(
                balanceada(ecuacionN)
        );


    }
    static boolean estaLaLetra(String frase,char l){
        char[] letras=frase.toCharArray();
        for(char letra : letras){
            if(letra==l){
                return true;
            }
        }
        return false;
    }
    static boolean balanceada(String ecuacion){
        String aperturasN="";
        String cierresN="";
        for(char h : ecuacion.toCharArray()){
            if(h=='{'){
                aperturasN+='1';
            }
            if(h=='['){
                aperturasN+='2';
            }
            if(h=='('){
                aperturasN+='3';
            }
            if(h==')'){
                cierresN+='1';
            }
            if(h==']'){
                cierresN+='2';
            }
            if(h=='}'){
                cierresN+='3';
            }
        }
        System.out.println(cierresN);
        System.out.println(aperturasN);
        return cierresN.equalsIgnoreCase(aperturasN);
    }
}
