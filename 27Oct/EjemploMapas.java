import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EjemploMapas {
    public static void main(String[] args) {
        Map<Integer, String> productosHash = new HashMap<>();
        productosHash.put(301, "Laptop");
        productosHash.put(105, "Teclado");
        productosHash.put(202, "Monitor");
        System.out.println("--- HASHMAP (Orden impredecible) ---");
        for (Map.Entry<Integer, String> entrada : productosHash.entrySet()) {
            System.out.println(
                "Código: " + entrada.getKey() +
                " | Producto: " + entrada.getValue()
            );
        }
        Map<Integer, String> productosTree = new TreeMap<>();
        productosTree.put(301, "Laptop");
        productosTree.put(105, "Teclado");
        productosTree.put(202, "Monitor");
        System.out.println("\n--- TREEMAP (Ordenado por llave) ---");
        for (Map.Entry<Integer, String> entrada : productosTree.entrySet()) {
            System.out.println(
                "Código: " + entrada.getKey() +
                " | Producto: " + entrada.getValue()
            );
        }
        int codigoBuscar = 202;
        System.out.println("\nBúsqueda del código " + codigoBuscar + ":");
        if (productosHash.containsKey(codigoBuscar)) {
            System.out.println(
                "Producto encontrado: " +
                productosHash.get(codigoBuscar)
            );
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}