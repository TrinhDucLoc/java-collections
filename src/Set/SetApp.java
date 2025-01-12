package Set;

import Map.HashMap2.Person;

import java.util.HashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();

        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));
        set.add(new Person("Kevin", 25));

    }
}
