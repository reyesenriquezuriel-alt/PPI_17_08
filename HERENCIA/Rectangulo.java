class Rectangulo extends Figura {
    private double longitud;
    private double ancho;

    public Rectangulo(double longitud, double ancho) {
        this.longitud = longitud;
        this.ancho = ancho;
    }

    double calcularArea() {
        return longitud * ancho;
    }
}