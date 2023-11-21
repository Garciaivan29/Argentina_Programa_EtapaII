import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Ergy");

        List<String> newList = toUpperCase(list);

        for (String str : newList) {
            System.out.println(str);
        }
    }

    public static List<String> toUpperCase(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            newList.add(str.toUpperCase());
        }
        return newList;
    }
}