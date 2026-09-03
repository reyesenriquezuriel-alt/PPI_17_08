public class Figura {
    abstract class FiguraBase {
        abstract double calcularArea();

        void mostrarNombre() {
            System.out.println("Esta es una figura");
        }
    }


    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(5, 3);
        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());

        Circulo circulo = new Circulo(2);
        System.out.println("Área del círculo: " + circulo.calcularArea());
    }

}
