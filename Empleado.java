public abstract class Empleado {
    protected String nombre;
    protected String cedula;
    protected double sueldoBase;
    protected int id;
    private static  int totalEmpleados = 0;
    private static int proxId = 1001;

    public Empleado(String nombre, String cedula, double sueldoBase) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sueldoBase = sueldoBase;
        this.id = proxId;
        proxId++;
        totalEmpleados++;
    }

    public abstract double calcularSueldo();
    public abstract String obtenerDetalles();
    public static int obtenerTotalEmpleados() {
        return totalEmpleados;
    }
    public static int obtenerProximoId() {
        return proxId;
    }
     public static void mostrarEstadisticas(Empleado[] empleados) {

        double totalNomina = 0;
        double mayorSueldo = 0;
        double menorSueldo = Double.MAX_VALUE;

        for (Empleado empleado : empleados) {

            double sueldo = empleado.calcularSueldo();

            totalNomina += sueldo;

            if (sueldo > mayorSueldo) {
                mayorSueldo = sueldo;
            }

            if (sueldo < menorSueldo) {
                menorSueldo = sueldo;
            }
        }

        double promedio = totalNomina / empleados.length;

        System.out.println("           ESTADÍSTICAS");
        System.out.println("Total de empleados: " + totalEmpleados);
        System.out.printf("Total de nómina: $%.2f%n", totalNomina);
        System.out.printf("Sueldo promedio: $%.2f%n", promedio);
        System.out.printf("Sueldo mayor: $%.2f%n", mayorSueldo);
        System.out.printf("Sueldo menor: $%.2f%n", menorSueldo);
    }

        public static void main(String[] args) {

        // Array polimórfico con 8 empleados
        Empleado[] empleados = new Empleado[8];

        // Crear instancias de Supervisor, Gerente y Obrero
        empleados[0] = new Supervisor("Juan Pérez", "123456789", 3000);
        empleados[1] = new Gerente("María López", "987654321", 5000);                  
        empleados[2] = new Obrero("Carlos Gómez", "456789123", 2000);
        empleados[3] = new Supervisor("Ana Torres", "321654987", 3200);
        empleados[4] = new Gerente("Luis Ramírez", "654987321", 5500);
        empleados[5] = new Obrero("Sofía Martínez", "789123456", 2200);
        empleados[6] = new Supervisor("Pedro Sánchez", "147258369", 3500);
        empleados[7] = new Gerente("Laura Fernández", "963852741", 6000);  


    mostrarEstadisticas(empleados);
    }

}
