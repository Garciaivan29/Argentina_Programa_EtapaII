public class Main {
    public static void main(String[] args) {
        Cancion theScientist = new Cancion("The Scientist", "Coldplay", "A Rush of Blood to the Head", 2002);

        // Casos de prueba
        theScientist.lanzar();
        System.out.println(theScientist.obtenerInfoConIconos(Icono.MUSICAL_NOTE) + " está recién lanzada.");

        theScientist.enAuge();
        System.out.println(theScientist.obtenerInfoConIconos(Icono.ROCKET) + " está en auge.");

        theScientist.fueraDelAuge();
        System.out.println(theScientist.obtenerInfoConIconos(Icono.FIRE) + " baja del auge.");

        theScientist.enTendencia();
        System.out.println(theScientist.obtenerInfoConIconos(Icono.MUSICAL_NOTE) + " es tendencia.");

        theScientist.volverANormal();
        System.out.println(theScientist.obtenerInfoConIconos(Icono.ROCKET) + " vuelve a ser normal.");
    }
}

class Icono {
    public static Icono MUSICAL_NOTE = new Icono(new int[]{0xD83C, 0xDFB5});
    public static Icono ROCKET = new Icono(new int[]{0xD83D, 0xDE80});
    public static Icono FIRE = new Icono(new int[]{0xD83D, 0xDD25});
    private int[] internalEncoding;

    Icono(int[] internalEncoding) {
        this.internalEncoding = internalEncoding;
    }

    public String texto() {
        StringBuilder builder = new StringBuilder();
        for (int codePoint : internalEncoding) {
            builder.append(Character.toChars(codePoint));
        }
        return builder.toString();
    }
}

class Cancion {
    private String nombre;
    private String artista;
    private String album;
    private int anoAlbum;
    private int popularidad;

    public Cancion(String nombre, String artista, String album, int anoAlbum) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.anoAlbum = anoAlbum;
        this.popularidad = 0; // Inicialmente con popularidad normal
    }

    // Métodos para gestionar la popularidad
    public void lanzar() {
        popularidad = 0;
    }

    public void enAuge() {
        popularidad = 1;
    }

    public void fueraDelAuge() {
        popularidad = -1;
    }

    public void enTendencia() {
        popularidad = 2;
    }

    public void volverANormal() {
        popularidad = 0;
    }

    // Método para obtener información de la canción con iconos
    public String obtenerInfoConIconos(Icono icono) {
        String iconoStr = icono.texto();
        return iconoStr + " " + nombre + " - " + artista + " (" + album + ", " + anoAlbum + ")";
    }
}
