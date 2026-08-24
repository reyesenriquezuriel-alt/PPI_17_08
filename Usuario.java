public class Usuario {
    private String nombre;
private static int total = 0;

public Usuario(String nombre) {
    this.nombre = nombre;
    total++;
}
public static int ObtenerTotal() {
    return total;
}
public static void main(String[] args) {
    new Usuario("Juan");
new Usuario("María");
new Usuario("Pedro");
new Usuario("Ana");
System.out.println("Total de usuarios: " + Usuario.ObtenerTotal());
}
}

