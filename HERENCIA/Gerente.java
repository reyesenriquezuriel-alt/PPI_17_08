public class Gerente extends Empleado {
    
    private static final double BONIFICACION = 0.25;

    public Gerente(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }

    public double calcularSueldo() {
        return sueldoBase + (sueldoBase * BONIFICACION);
    }

    public String obtenerDetalles() {
        return "Gerente";
    }
}