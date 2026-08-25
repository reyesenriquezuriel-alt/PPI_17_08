public class Supervisor extends Empleado {
    
    private static final double BONIFICACION = 0.15;

    public Supervisor(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }

    public double calcularSueldo() {
        return sueldoBase + (sueldoBase * BONIFICACION);
    }

    public String obtenerDetalles() {
        return "Supervisor";
    }
}
