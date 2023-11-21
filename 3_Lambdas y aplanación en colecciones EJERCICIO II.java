import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("ergy");
        strings.add("programming");
        strings.add("ergy of programming");
        strings.add("how are you");
        strings.add("who am i");

        int n = 6;

        System.out.println(longerThanN(strings, n));
    }

    public static String longerThanN(List<String> list, int n) {
        List<String> filteredStrings = new ArrayList<>();

        for (String str : list) {
            if (str.length() > n) {
                filteredStrings.add(str);
            }
        }

        if (filteredStrings.isEmpty()) {
            return "No string found with more than " + n + " characters.";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < filteredStrings.size() - 1; i++) {
            result.append(filteredStrings.get(i)).append(", ");
        }

        result.append(filteredStrings.get(filteredStrings.size() - 1));

        return result.toString();
    }
}