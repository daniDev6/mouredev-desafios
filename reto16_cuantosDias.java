import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class reto16_cuantosDias {
    public static void main(String[] args) {
        /*
         * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
         * de texto que representen fechas.
         * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
         * - La función recibirá dos String y retornará un Int.
         * - La diferencia en días será absoluta (no importa el orden de las fechas).
         * - Si una de las dos cadenas de texto no representa una fecha correcta se
         *   lanzará una excepción.
         */
        //Variables
        Scanner scanner=new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Bienvenido ala aplicacion que calcula los dias entre fechas");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        boolean centinella=true;
        boolean centinella2=true;
        boolean centinella3=true;
        LocalDate fecha1=null;
        LocalDate fecha2=null;
        while (centinella){

        System.out.println("Para comenzar ingrese una fecha: ");

        while (centinella3){
            String string1 = scanner.nextLine();
            System.out.println(string1+"eheuehui");
            fecha1 = devuelveFecha(string1);
            System.out.println("Soy fecha 1: "+fecha1);
        if(fecha1==null){
            System.out.println("Debe ingresar una fecha valida");
        }else {
            centinella3=false;
        }
        }

        while(centinella2){
            System.out.println("Ingrese otra fecha");
            String string2 = scanner.nextLine();

        fecha2 = devuelveFecha(string2);
        if(fecha2==null){
            System.out.println("Debe ingresar una fecha valida");
        }else {
            centinella2=false;
        }
        }
        if(fecha1 !=null && fecha2 !=null){
            System.out.println("La diferencia en dias es : "+diferenciaDias(fecha1,fecha2));
        }
            System.out.println("Desea salir Ingrese terminar");
            centinella = scanner.nextLine().equalsIgnoreCase("terminar")?false:true;
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("----------------Gracias por utilizar nuestra app ----------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");























    }
    static LocalDate devuelveFecha(String fecha){
        DateTimeFormatter formato=DateTimeFormatter.ofPattern( "dd/MM/yyyy");
        try{
            System.out.println(LocalDate.parse(fecha,formato) + "Soy fecha parseada");
        return LocalDate.parse(fecha,formato);
        }catch (Exception e){
            new RuntimeException("Error al parsear la fecha");
            System.out.println("no se pudo parsear");
            return null;
        }
    }
    static long diferenciaDias(LocalDate fecha, LocalDate fecha2){
        return ChronoUnit.DAYS.between(fecha,fecha2);
    }
}
