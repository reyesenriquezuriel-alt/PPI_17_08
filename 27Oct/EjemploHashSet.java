public class EjemploHashSet {
    public static void main(String[] args) {
        // 1. Crear un HashSet
        java.util.HashSet<String> usuarios = new java.util.HashSet<>();

        // 2. Agregar elementos al HashSet
        usuarios.add("Alice");
        usuarios.add("Bob");
        usuarios.add("Charlie");
        usuarios.add("David");
        usuarios.add("Eve");

        // 3. Intentar agregar un elemento duplicado (no se agregará)
        boolean seAgrego = usuarios.add("Alice");
        System.out.println("¿Se agregó 'Alice' nuevamente? " + seAgrego);

        // 4. Mostrar los elementos del HashSet
        if(usuarios.contains("Charlie")) {
            System.out.println("Charlie está en el HashSet.");
        } 

        usuarios.remove("David");
        System.out.println("\nUsuarios registros actuales:");
        for (String usuario : usuarios) {
            System.out.println("- " + usuario);
        }
    }
}
        