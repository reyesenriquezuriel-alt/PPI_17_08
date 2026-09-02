public class Obrero extends Empleado{

    private static final double BONIFICACION = 0.00;

    public Obrero(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }

    public double calcularSueldo() {
        return sueldoBase + (sueldoBase * BONIFICACION);
    }

    public String obtenerDetalles() {
        return "Obrero";
    }
    
}