import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> lista = List.of("hello", "ergy");
        Function<String, String> mayusculas = String::toUpperCase;
        List<String> result = transformar(lista, mayusculas);
        System.out.println(result); // Imprime [HOLA, ERGY]
    }

    public static List<String> transformar(List<String> lista, Function<String, String> funcion) {
        return lista.stream()
                .map(funcion)
                .collect(Collectors.toList());
    }
}