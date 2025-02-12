public class reto5_areaPoligono {
    public static void main(String[] args) {
        /*
         * Crea una única función (importante que sólo sea una) que sea capaz
         * de calcular y retornar el área de un polígono.
         * - La función recibirá por parámetro sólo UN polígono a la vez.
         * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
         * - Imprime el cálculo del área de un polígono de cada tipo.
         */
        Triangulo triangulo=new Triangulo(3,4);
        Rectangulo rectangulo=new Rectangulo(4,5);
        Cuadrado cuadrado = new Cuadrado(6);
        System.out.println(triangulo.area());
        System.out.println(rectangulo.area());
        System.out.println(cuadrado.area());
        double num1=3;
        double num2=4;
        System.out.println(num1*num2/2);



    }
}
class Triangulo extends Poligono {
    private double base;
    private double altura;

    @Override
    double area() {
        return this.altura*this.base/2;
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
}
class Rectangulo extends Poligono{
    private double base;
    private double altura;
    @Override
    double area() {
        return this.base*this.altura;
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
}
class Cuadrado extends Poligono{
    private double lado;
    @Override
    double area() {
        return lado*lado;
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }
}

abstract class Poligono{
    abstract double area();
}