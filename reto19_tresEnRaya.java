import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class reto19_tresEnRaya {
    public static void main(String[] args) {
        /*
         * Crea una función que analice una matriz 3x3 compuesta por "X" y "O"
         * y retorne lo siguiente:
         * - "X" si han ganado las "X"
         * - "O" si han ganado los "O"
         * - "Empate" si ha habido un empate
         * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
         *   O si han ganado los 2.
         * Nota: La matriz puede no estar totalmente cubierta.
         * Se podría representar con un vacío "", por ejemplo.
         */
        String[][] tablero = {
                {"*","*","*"},
                {"*","*","*"},
                {"*","*","*"},
        };
        boolean xOrO=true;
        String turno;
        Scanner sc=new Scanner(System.in);
        int contador=0;
        while(true){
            System.out.println("Comienza el juego");
            System.out.println("Indique posicion en fila y columna");
            mostrarTablero(tablero);
            System.out.println("Ingrese una fila: ");
            int fila= sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese una columna");
            int columna= sc.nextInt();
            sc.nextLine();
            turno=xOrO?"X":"O";
            if(estaVacio(tablero,fila,columna)){

            tablero=jugando(tablero,fila,columna,turno);
            xOrO=!xOrO;
            }else{
                System.out.println("Ingrese otra posicion");
            }

            contador++;
            if(contador==20){
                break;
            }
        }















        String ganador= ganador(tablero);
        System.out.println("El resultado de la partida es: " + ganador);

    }
    //matrices ganadoras
    /*horizontal
     * i=0 y j=0,1,2
     * i=1 y j=0,1,2
     * i=2 y j=0,1,2
     * vertical
     * i=0,1,2 y j=0
     * i=0,1,2 y j=1
     * i=0,1,2 y j=2
     * diagonal
     * i=0 y j=0
     * i=1 y j=1
     * i=2 y j=2
     * diagonal inversa
     *
     * i=0 y j=2
     * i=1 y j=1
     * i=2 y j=0
     *

     * */
    static void mostrarTablero(String[][] tablero){
        System.out.println("columnas   0    1    2  ");
        for(int i=0;i<tablero.length;i++){
            System.out.print("fila "+ i +" : ");
            for(int j=0;j< tablero.length;j++){
                System.out.print("  "+tablero[i][j]+"  ");
            }
            System.out.println();
        }
    }
    static boolean estaVacio(String[][] tablero,int fila,int columna){
        return tablero[fila][columna].isBlank()||tablero[fila][columna].isEmpty()||(!tablero[fila][columna].equalsIgnoreCase("X")&&!tablero[fila][columna].equalsIgnoreCase("O"));
    }
    static Pieza horizontales(String[][] tablero){
        int contador=0;
        int k=0;
        String auxiliar;
        for(int i=0;i<tablero.length;i++){
            contador=0;
            auxiliar=tablero[i][0];
            for(int j=0;j< tablero.length;j++){

                if(auxiliar.equalsIgnoreCase(tablero[i][j])){
                    contador++;

                }
            }
            k++;

            if(contador==3){
                return new Pieza(auxiliar,true);
            }

        }
        return new Pieza("Sin ganador",false);
    }
    static Pieza verticales(String[][] tablero){
        int contador=0;
        int k=0;
        String auxiliar;
        for(int j=0;j<tablero.length;j++){
            contador=0;
            auxiliar=tablero[0][j];
            for(int i=0;i< tablero.length;i++){

                if(auxiliar.equalsIgnoreCase(tablero[i][j])){
                    contador++;

                }
            }
            k++;

            if(contador==3){
                return new Pieza(auxiliar,true);
            }

        }
        return new Pieza("Sin ganador",false);
    }
    static Pieza diagonales(String[][] tablero){
        int contador=0;
        String auxiliar="";
        for(int i=0;i<tablero.length;i++){
            auxiliar=tablero[0][0];
            if(tablero[i][i].equalsIgnoreCase(auxiliar)){
                contador++;
            }
        }
        if(contador==3){
            return new Pieza(auxiliar,contador==3);
        }else {
            return new Pieza("Sin ganador",false);
        }

    }
    static Pieza diagonalInversa(String[][] tablero){
        String auxiliar="";
        int k=2;
        int contador=0;
        for(int i=0;i<3;i++){
            auxiliar=tablero[0][2];
            if(tablero[i][k].equalsIgnoreCase(auxiliar)){
                contador++;
            }
            k--;
        }
        if(contador==3){
            return new Pieza(auxiliar,contador==3);
        }else {
            return new Pieza("Sin ganador",false);
        }
    }
    static String ganador(String[][] tablero){
        if(!tableroValido(tablero)) return "Partida Invalida tablero mal";
        String ganador="Empate";
        Pieza p1=horizontales(tablero);
        Pieza p2=verticales(tablero);
        Pieza p3=diagonales(tablero);
        Pieza p4=diagonalInversa(tablero);
        List<Pieza> listaProbabilidades = new ArrayList<>();
        listaProbabilidades.add(p1);
        listaProbabilidades.add(p2);
        listaProbabilidades.add(p3);
        listaProbabilidades.add(p4);
        int contador=0;
        for(Pieza p : listaProbabilidades){
            if(p.isGanoPerdio()){
                contador++;
                ganador=contador==1? "El ganador fue " + p.getNombre().toUpperCase() : "Partida invalida mas de un ganador";
            }
        }
        if(!finJuego(tablero) && ganador.equalsIgnoreCase("empate")) return "Todavia hay lugares a ocupar";
        if(desproporcionJuego(tablero)) return "Juego Desproporcionado";
        return ganador;
    }
    static int pruebaVector(String[] tablero, int fila){
        int contador=0;
        for(int i=0;i<tablero.length;i++){
            if(tablero[i]==tablero[fila]){
                contador++;
            }
        }
        return contador;
    }
    static boolean pruebaHorisontales(String[][] tablero){
        int contador=0;
        int k=0;
        for(String[] vector : tablero){
            if(pruebaVector(vector,k)==3){
                contador++;
            }
            k++;
        }
        return contador==1;
    }
    static boolean tableroValido(String[][] tablero){
        for(int i=0;i< tablero.length;i++){
            for(int j=0;j< tablero.length;j++){
                if(!tablero[i][j].equalsIgnoreCase("X") && !tablero[i][j].equalsIgnoreCase("O")&&!tablero[i][j].equalsIgnoreCase(" ")){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean finJuego(String[][] tablero){
        for(int i=0;i< tablero.length;i++){
            for(int j=0;j< tablero.length;j++){
                if(!tablero[i][j].equalsIgnoreCase("X") && !tablero[i][j].equalsIgnoreCase("O")){
                    if(tablero[i][j].equalsIgnoreCase(" ")){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean desproporcionJuego(String[][] tablero){
        int cantX=0;
        int cantO=0;
        if(finJuego(tablero)){
            for(int i=0;i< tablero.length;i++){
                for(int j=0;j< tablero.length;j++){
                    if(tablero[i][j].equalsIgnoreCase("X")){
                        cantX++;
                    }else if(tablero[i][j].equalsIgnoreCase("O")){
                        cantO++;
                    }
                    }
                }
            }
        System.out.println(cantX + " x cant o "+cantO);
        return cantO!=cantX && !(cantX==5 && cantO==4);


    }
    static String[][] jugando(String[][] tablero,int fila, int columna,String turno){
        if(tablero[fila][columna].equalsIgnoreCase("X") || tablero[fila][columna].equalsIgnoreCase("O")){
            System.out.println("Esta ocupado el lugar");
            return tablero;
        }
                tablero[fila][columna]=turno;

        return tablero;
    }












}
class Pieza{
    private String nombre;
    private boolean ganoPerdio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGanoPerdio() {
        return ganoPerdio;
    }

    public void setGanoPerdio(boolean ganoPerdio) {
        this.ganoPerdio = ganoPerdio;
    }

    public Pieza() {
    }

    public Pieza(String nombre, boolean ganoPerdio) {
        this.nombre = nombre;
        this.ganoPerdio = ganoPerdio;
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "nombre='" + nombre + '\'' +
                ", ganoPerdio=" + ganoPerdio +
                '}';
    }
}
