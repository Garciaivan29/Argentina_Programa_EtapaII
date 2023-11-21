import java.util.ArrayList;
import java.util.List;

class Alumno {
    private String nombre;
    private List<Materia> materiasCursadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        materiasCursadas = new ArrayList<>();
    }

    public void cursar(Materia materia) {
        materiasCursadas.add(materia);
    }

    public boolean cursada(List<Materia> materias) {
        for (Materia materia : materias) {
            if (!materiasCursadas.contains(materia)) {
                return false;
            }
        }
        return true;
    }
}

class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
}

class Inscripcion {
    private Alumno alumno;
    private Materia materia;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }

    public boolean aprobada() {
        return alumno.cursada(materia.getCorrelativas());
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear alumnos
        Alumno alumno1 = new Alumno("Alumno 1");
        Alumno alumno2 = new Alumno("Alumno 2");

        // Crear materias con correlativas
        Materia materia1 = new Materia("Materia 1", new ArrayList<>());
        Materia materia2 = new Materia("Materia 2", List.of(materia1));
        Materia materia3 = new Materia("Materia 3", List.of(materia2));

        // Inscribir alumnos en materias
        alumno1.cursar(materia1);
        alumno1.cursar(materia2);
        alumno2.cursar(materia1);
        alumno2.cursar(materia3);

        // Crear inscripciones y verificar si están aprobadas
        Inscripcion inscripcion1 = new Inscripcion(alumno1, materia2);
        Inscripcion inscripcion2 = new Inscripcion(alumno2, materia3);

        System.out.println("Alumno 1 aprobó Materia 2: " + inscripcion1.aprobada());
        System.out.println("Alumno 2 aprobó Materia 3: " + inscripcion2.aprobada());
    }
}