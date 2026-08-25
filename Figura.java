abstract class Figura {
    abstract double calcularArea();

    void mostrarNombre() {
        System.out.println("Esta es una figura");
    }

}
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(5, 3);
        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        
    }
