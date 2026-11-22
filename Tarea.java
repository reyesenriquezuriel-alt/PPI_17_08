public class Tarea {

    // 1. Division entre cero
    public static void dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }

        System.out.println("Resultado: " + (a / b));
    }

    // 2. Edad incorrecta
    public static void revisarEdad(int edad) throws IllegalArgumentException {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

        System.out.println("Edad: " + edad);
    }

    // 3. Nombre vacio
    public static void revisarNombre(String nombre) throws Exception {
        if (nombre == null || nombre.equals("")) {
            throw new Exception("El nombre esta vacio");
        }

        System.out.println("Nombre: " + nombre);
    }

    // 4. Numero negativo
    public static void revisarNumero(int numero) throws Exception {
        if (numero < 0) {
            throw new Exception("El numero no puede ser negativo");
        }

        System.out.println("Numero correcto: " + numero);
    }

    // 5. Calificacion incorrecta
    public static void revisarCalificacion(double calificacion) throws Exception {
        if (calificacion < 0 || calificacion > 10) {
            throw new Exception("La calificacion no es valida");
        }

        System.out.println("Calificacion: " + calificacion);
    }

    // 6. Saldo insuficiente
    public static void retirar(double saldo, double cantidad) throws Exception {
        if (cantidad > saldo) {
            throw new Exception("No tienes suficiente saldo");
        }

        System.out.println("Retiro realizado");
        System.out.println("Saldo restante: " + (saldo - cantidad));
    }


    // Codigo para ejecutar las excepciones
    public static void main(String[] args) {

        // Excepcion 1
        try {
            dividir(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error 1: " + e.getMessage());
        }

        // Excepcion 2
        try {
            revisarEdad(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error 2: " + e.getMessage());
        }

        // Excepcion 3
        try {
            revisarNombre("");
        } catch (Exception e) {
            System.out.println("Error 3: " + e.getMessage());
        }

        // Excepcion 4
        try {
            revisarNumero(-20);
        } catch (Exception e) {
            System.out.println("Error 4: " + e.getMessage());
        }

        // Excepcion 5
        try {
            revisarCalificacion(15);
        } catch (Exception e) {
            System.out.println("Error 5: " + e.getMessage());
        }

        // Excepcion 6
        try {
            retirar(500, 800);
        } catch (Exception e) {
            System.out.println("Error 6: " + e.getMessage());
        }
    }
}
//investigarcion de excepciones, clases abstractas y interfaces