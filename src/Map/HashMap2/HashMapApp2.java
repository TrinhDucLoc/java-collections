package Map.HashMap2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapApp2 {
    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<>();

        map.put("Adam", new Person("Kevin", 23));
        map.put("Adam", new Person("Kevin", 23));
        map.put("Adam", new Person("Kevin", 23));
        map.put("Adam", new Person("Kevin", 23));


        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        Set<Person> set = new HashSet<>();

        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));

    }
}
