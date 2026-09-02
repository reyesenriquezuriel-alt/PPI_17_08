abstract class Animal {
    protected String nombre;
    protected int energia;

    public Animal(String nombre) {
        this.nombre = nombre;
        this.energia = 100;
    }

    public abstract void hacerSonido();
    public abstract void moverse();

    public void dormir() {
        energia += 20;
        System.out.println(nombre + " está durmiendo. Energía: " + energia);
    }

    public void comer() {
        energia += 10;
        System.out.println(nombre + " está comiendo. Energía: " + energia);
    }
}

// Subclase Perro
class Perro extends Animal {
    private String raza;

    public Perro(String nombre, String raza) {
        super(nombre);
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau!");
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " corre alegremente.");
    }

    public void traerObjeto() {
        System.out.println(nombre + " trae la pelota.");
    }
}

// Subclase Gato
class Gato extends Animal {
    private String color;

    public Gato(String nombre, String color) {
        super(nombre);
        this.color = color;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau!");
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " camina sigilosamente.");
    }

    public void rasgunar() {
        System.out.println(nombre + " rasguña el sillón.");
    }
}

// Subclase Pajaro
class Pajaro extends Animal {
    private double envergaduraAlas;

    public Pajaro(String nombre, double envergaduraAlas) {
        super(nombre);
        this.envergaduraAlas = envergaduraAlas;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Pío!");
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " vuela por el cielo.");
    }

    public void volar() {
        System.out.println(nombre + " está volando.");
    }
}

// Subclase Vaca
class Vaca extends Animal {
    private String tipo;

    public Vaca(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Muuu!");
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " camina lentamente por el campo.");
    }

    public void darLeche() {
        System.out.println(nombre + " está dando leche.");
    }
}

// Subclase Oveja
class Oveja extends Animal {
    private String lanaColor;

    public Oveja(String nombre, String lanaColor) {
        super(nombre);
        this.lanaColor = lanaColor;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Beeee!");
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " se mueve en grupo.");
    }

    public void producirLana() {
        System.out.println(nombre + " produce lana de color " + lanaColor + ".");
    }
}

// Clase principal
public class SistemaAnimales {
    
    public static void main(String[] args) {
        Animal[] animales = {
            new Perro("Max", "Labrador"),
            new Gato("Sheila", "Blanco"),
            new Pajaro("Carmin", 0.25),
            new Vaca("Mia", "Lechera"),
            new Oveja("Sol", "Blanca")
        };

        for (Animal a : animales) {
            a.hacerSonido();
            a.moverse();
            a.comer();
            a.dormir();
            System.out.println("-------------------");
        }
    }
}