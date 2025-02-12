import java.util.Scanner;

public class reto18_carrera {
    public static void main(String[] args) {
        /*
         * Crea una función que evalúe si un/a atleta ha superado correctamente una
         * carrera de obstáculos.
         * - La función recibirá dos parámetros:
         *      - Un array que sólo puede contener String con las palabras
         *        "run" o "jump"
         *      - Un String que represente la pista y sólo puede contener "_" (suelo)
         *        o "|" (valla)
         * - La función imprimirá cómo ha finalizado la carrera:
         *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla)
         *        será correcto y no variará el símbolo de esa parte de la pista.
         *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
         *      - Si hace "run" en "|" (valla), se variará la pista por "/".
         * - La función retornará un Boolean que indique si ha superado la carrera.
         * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
         */
        String[] pistaReal={
                "_","|","_","|","_"
        };
        String[] pistaAtleta = ingresePista(pistaReal.length);
        System.out.println("Pista del corredor: ");
        mostrarPista(pistaAtleta);
        if(pistaCambio(pistaAtleta,pistaReal)){
            System.out.println("Pudo completar la carrera");
        }else{
            System.out.println("no pudo completar la carrera");
        }
        System.out.println("Pista de la carrera del atleta");
        mostrarPista(pistaAtleta);
        System.out.println("Pista Real de la carrera");
        mostrarPista(pistaReal);


    }
    static String analizaObstaculo(String atleta,String pista){
        if(atleta.equalsIgnoreCase("jump") && pista.equalsIgnoreCase("_")){
            return "x";
        } else if (atleta.equalsIgnoreCase("run") && pista.equalsIgnoreCase("|")) {
            return "/";
        }else{
            return pista;
        }
    }
    static boolean pistaCambio(String[] pista, String[] carrera){
        cambiarPistaAtleta(pista,carrera);
        for(int i=0;i<pista.length;i++){
            if(!pista[i].equalsIgnoreCase(carrera[i])){
                return false;
            }
        }
        return true;
    }
    static boolean verificaPista(String pista){
        return pista.equalsIgnoreCase("run") || pista.equalsIgnoreCase("jump");
    }
    static boolean verificaPista(String[] pista,String[] pistaReal){
        return pista.length!=pistaReal.length;
    }

    static String[] ingresePista(int tamanio){
        String[] pistaTotal = new String[tamanio];
        Scanner scanner = new Scanner(System.in);
        String pista ="";
        boolean centinella=true;
        for(int i=0;i<pistaTotal.length;i++){
            while(centinella){
                System.out.println("Ingrese pista");
            pista=scanner.nextLine();
            if(verificaPista(pista)){
                pistaTotal[i]=pista;
                centinella=false;
            }else {
                System.out.println("La pista no puede ser diferente a run o jump!!");
            }
            }
            centinella=true;
        }
        return pistaTotal;


    }
    static void cambiarPistaAtleta(String[] pistaAtleta,String[] pistaReal){
        for(int i=0;i<pistaAtleta.length;i++){
            pistaAtleta[i]=analizaObstaculo(pistaAtleta[i],pistaReal[i]);
        }
    }
    static void mostrarPista(String[] pista){
        System.out.println("Inicia la pista ");
        for(int i=0;i<pista.length;i++){
            System.out.print( " " +pista[i] + " ");
        }
        System.out.println();
        System.out.println("Termina la pista");
    }


}
