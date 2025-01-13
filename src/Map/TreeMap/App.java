package Map.TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        TreeMap<String, Integer> map2 = new TreeMap<>(Comparator.reverseOrder());

        map.put("Adam", 10);
        map.put("Kevin", 43);
        map.put("Ana", 56);
        map.put("Daniel", 21);
        map.put("Katy", 10);

        System.out.println("Last key : " + map.lastKey());
        System.out.println("First key: " + map.firstKey());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
