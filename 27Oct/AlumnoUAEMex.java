// Archivo: AlumnoUAEMex.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class AlumnoUAEMex implements Comparable<AlumnoUAEMex> {
    private int cuenta;
    private String nombre;
    private double promedio;
    public AlumnoUAEMex(int cuenta, String nombre, double promedio) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.promedio = promedio;
    }
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
    @Override
    public int compareTo(AlumnoUAEMex otro) {
        // Criterio: Ordenar de forma descendente por promedio (Mayor a Menor)
        if (this.promedio < otro.promedio) return 1;
        if (this.promedio > otro.promedio) return -1;
        return 0;
    }
    @Override
    public String toString() {
        return "Alumno: " + nombre + " | Promedio: " + promedio;
    }
    public static void main(String[] args) {
        List<AlumnoUAEMex> grupo = new ArrayList<>();
        grupo.add(new AlumnoUAEMex(182401, "Beatriz", 8.5));
        grupo.add(new AlumnoUAEMex(182402, "Alejandro", 9.2));
        grupo.add(new AlumnoUAEMex(182403, "Daniela", 9.8));

        Collections.sort(grupo);
        System.out.println("=== Alumnos ordenados por Promedio (Natural) ===");
        for (AlumnoUAEMex al : grupo) {
            System.out.println(al);
        }
    }
}