public class Main {
    public static void main(String[] args) {
        // Crear alumnos
        Alumno alumno1 = new Alumno("Juan", "Perez");
        Alumno alumno2 = new Alumno("María", "Rodríguez");

        // Crear materias
        Materia materia1 = new Materia("Matemáticas");
        Materia materia2 = new Materia("Español");

        // Agregar correlativas
        materia1.agregarCorrelativa(materia2);

        // Inscribir alumnos en las materias
        alumno1.agregarInscripcion(new Inscripcion(materia1, alumno1, 8));
        alumno1.agregarInscripcion(new Inscripcion(materia2, alumno1, 6));
        alumno2.agregarInscripcion(new Inscripcion(materia1, alumno2, 7));
        alumno2.agregarInscripcion(new Inscripcion(materia2, alumno2, 5));

        // Verificar aprobaciones
        for (Alumno alumno : Arrays.asList(alumno1, alumno2)) {
            for (Inscripcion inscripcion : alumno.getInscripciones()) {
                System.out.println("El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " está aprobado en " + inscripcion.getMateria().getNombre() + ": " + inscripcion.estaAprobado());
            }
        }
    }
}

class Alumno {
    private String nombre;
    private String apellido;
    private List<Inscripcion> inscripciones;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.inscripciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}

class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
}

class Inscripcion {
    private Materia materia;
    private Alumno alumno;
    private int nota;

    public Inscripcion(Materia materia, Alumno alumno, int nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Materia getMateria() {
        return materia;
    }

    public boolean estaAprobado() {
        boolean cumpleCorrelativas = true;
        for (Materia correlativa : materia.getCorrelativas()) {
            if (!alumno.getInscripciones().stream().anyMatch(inscripcion -> inscripcion.getMateria().equals(correlativa) && inscripcion.estaAprobado())) {
                cumpleCorrelativas = false;
                break;
            }
        }
        return cumpleCorrelativas&&