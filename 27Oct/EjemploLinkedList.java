import java.util.LinkedList;


public class EjemploLinkedList {
    public static void main(String[] args) {
        // 1. Crear una lista doblemente enlazada 
       LinkedList<String> tareas = new LinkedList<>();
        // 2. Agregar elementos a la lista de manera formal
        tareas.add("Cocinar");
        tareas.add("Estudiar");

        // 3. Ventaja: Metodos rapidos para los extremos de la lista
        tareas.addFirst("Despertar(Primero)");
        tareas.addLast("Dormir(Ultimo)");

        // 4. Obtener elementos(es mas lento que un ArrayList)
        System.out.println("Primera tarea: " + tareas.getFirst());

        // 5. Eliminar elementos de los extremos de la lista
        tareas.removeFirst();
        tareas.removeLast();

        // 6. Recorrer la lista
        System.out.println("\nTareas restantes:");
        for (String tarea : tareas) {
            System.out.println("- " + tarea);
        }
    }
}