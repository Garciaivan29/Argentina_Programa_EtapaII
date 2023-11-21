import java.util.Random;

public class PruebaDePopularidad {

    public static void main(String[] args) {
        // Datos de prueba
        Cancion theScientist = new Cancion("The Scientist", "Coldplay", "A Rush of Blood to the Head", 2002);
        int reproducciones = generarReproducciones();
        int likes = generarLikes();
        int dislikes = generarDislikes();

        // Caso 1: Recién lanzada (popularidad normal)
        theScientist.mostrarEstado("Recién lanzada");

        // Caso 2: Está en auge por superar el mínimo de reproducciones esperadas
        if (reproducciones > Cancion.MIN_REPRODUCCIONES_ESPERADAS) {
            theScientist.setAuge(true);
            theScientist.mostrarEstado("Está en auge");
        }

        // Caso 3: Baja del auge por tener muchos dislikes
        if (dislikes > Cancion.MAX_DISLIKES) {
            theScientist.setAuge(false);
            theScientist.mostrarEstado("Baja del auge");
        }

        // Caso 4: Es tendencia por récord de reproducciones y cantidad de likes
        if (reproducciones > Cancion.RECORD_REPRODUCCIONES && likes > Cancion.RECORD_LIKES) {
            theScientist.setTendencia(true);
            theScientist.mostrarEstado("Es tendencia");
        }

        // Caso 5: Era tendencia pero vuelve a ser normal por no ser escuchada en las últimas horas
        if (theScientist.isTendencia() && reproducciones == 0) {
            theScientist.setTendencia(false);
            theScientist.mostrarEstado("Era tendencia pero vuelve a ser normal");
        }
    }

    private static int generarReproducciones() {
        // Simula la generación aleatoria de reproducciones
        return new Random().nextInt(1000000);
    }

    private static int generarLikes() {
        // Simula la generación aleatoria de likes
        return new Random().nextInt(10000);
    }

    private static int generarDislikes() {
        // Simula la generación aleatoria de dislikes
        return new Random().nextInt(1000);
    }
}

class Cancion {
    // Datos de la canción
    private String nombre;
    private String artista;
    private String album;
    private int anio;

    // Estado de la canción
    private boolean auge;
    private boolean tendencia;

    // Constantes
    public static final int MIN_REPRODUCCIONES_ESPERADAS = 500000;
    public static final int MAX_DISLIKES = 1000;
    public static final int RECORD_REPRODUCCIONES = 1000000;
    public static final int RECORD_LIKES = 5000;

    // Constructor
    public Cancion(String nombre, String artista, String album, int anio) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.anio = anio;
    }

    // Métodos getters y setters

    public void setAuge(boolean auge) {
        this.auge = auge;
    }

    public void setTendencia(boolean tendencia) {
        this.tendencia = tendencia;
    }

    // Método para mostrar el estado de la canción
    public void mostrarEstado(String mensaje) {
        System.out.println(Icono.MUSICAL_NOTE.texto() + " " + nombre + " de " + artista + " (" + album + ", " + anio + "): " + mensaje);
    }

    // Método para verificar si la canción es tendencia
    public boolean isTendencia() {
        return tendencia;
    }
}

class Icono {
    public static final Icono MUSICAL_NOTE = new Icono(new int[]{0xD83C, 0xDFB5});
    public static final Icono ROCKET = new Icono(new int[]{0xD83D, 0xDE80});
    public static final Icono FIRE = new Icono(new int[]{0xD83D, 0xDD25});
    private final int[] internalEncoding;

    private Icono(int[] internalEncoding) {
        this.internalEncoding = internalEncoding;
    }

    public String texto() {
        return new String(internalEncoding, 0, internalEncoding.length);
    }
}
