import java.util.LinkedHashSet;
import java.util.*;

class HashLInkedset{
    public static void main(String[] args) {
      Set<String> orderedSet = new LinkedHashSet<>();

        orderedSet.add("Apple");
        orderedSet.add("Banana");
        orderedSet.add("Orange");
        orderedSet.add("Apple"); // Duplicate element, will not be added

        // Using Iterator to iterate through the set
        Iterator<String> iterator = orderedSet.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}