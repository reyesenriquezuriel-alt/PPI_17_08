import java.util.ArrayList;

public class CuentaBancaria {

    // Atributos de instancia
    private String titular;
    private double saldo;
    private int id;

    // Variables static
    private static int totalCuentas = 0;
    private static int proxId = 1;

    // Lista para guardar todas las cuentas
    private static ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    // Constructor
    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;

        // Asignar ID y aumentar el próximo ID
        this.id = proxId;
        proxId++;

        // Aumentar contador de cuentas
        totalCuentas++;

        // Guardar cuenta
        cuentas.add(this);
    }

    // Getters
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    // Método static
    public static int obtenerTotalCuentas() {
        return totalCuentas;
    }

    // Método static
    public static int obtenerProximoId() {
        return proxId;
    }

    // Método static
    public static void reporteGlobal() {
        System.out.println("       REPORTE GLOBAL DE CUENTAS");


        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(
                "ID: " + cuenta.id +
                " | Titular: " + cuenta.titular +
                " | Saldo: $" + String.format("%.2f", cuenta.saldo)
            );
        }

        System.out.println("----------------------------------------");
        System.out.println("Total de cuentas: " + totalCuentas);
        System.out.println("Próximo ID: " + proxId);
    }
    public static void main(String[] args) {

    
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Pérez", 1500.00);
        CuentaBancaria cuenta2 = new CuentaBancaria("María López", 2500.50);
        CuentaBancaria cuenta3 = new CuentaBancaria("Carlos Gómez", 3200.75);
        CuentaBancaria cuenta4 = new CuentaBancaria("Ana Torres", 1800.00);
        CuentaBancaria cuenta5 = new CuentaBancaria("Luis Rodríguez", 4200.25);

        
        CuentaBancaria.reporteGlobal();

        System.out.println("\nTotal de cuentas creadas: "
                + CuentaBancaria.obtenerTotalCuentas());

        System.out.println("Próximo ID disponible: "
                + CuentaBancaria.obtenerProximoId());
    }
}