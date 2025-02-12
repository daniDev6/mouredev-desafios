public class reto3_fibonacci {
    public static void main(String[] args) {
        /*
         * Escribe un programa que imprima los 50 primeros números de la sucesión
         * de Fibonacci empezando en 0.
         * - La serie Fibonacci se compone por una sucesión de números en
         *   la que el siguiente siempre es la suma de los dos anteriores.
         *   0, 1, 1, 2, 3, 5, 8, 13...
         */

        long[] vector=new long[50];
        vector[0]=0;
        vector[1]=1;

        for(int i=1;i<vector.length-1;i++){
            vector[i+1]=vector[i-1] + vector[i];
        }
        for(int i =0; i<vector.length;i++){
            System.out.println(" fila "+i+" :"+vector[i] + " ");
        }









    }
}
