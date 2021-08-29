
import java.util.*;

public class HashAssignment {

    public static void main(String args[]) {
        List<List<Integer>> intLists = new LinkedList<>();

        intLists.add(new ArrayList<Integer>(Arrays.asList(11,25,17,9,82,56)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(25,44,37,12,67,82,17)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(14,12,82,9,65,11,17)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(33,51,12,17,11,82)));

        List<Integer> intResult = findCommonElements(intLists);

        System.out.println("Common elements of the integer list");
        System.out.println(intResult + "\n");

        List<List<String>> stringLists = new LinkedList<>();

        stringLists.add(new ArrayList<String>(Arrays.asList("a", "b", "d", "c", "h", "e")));
        stringLists.add(new ArrayList<String>(Arrays.asList("g", "b", "e", "j", "u", "z", "h", "d")));
        stringLists.add(new ArrayList<String>(Arrays.asList("y", "p", "b", "d")));

        List<String> stringResult = findCommonElements(stringLists);

        System.out.println("Common elements of the string list");
        System.out.println(stringResult);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> findCommonElements(List<List<T>> collections) {
        HashSet<T> hs = new HashSet<>();
        HashSet<T> tempHS = new HashSet<>();
        
        if (collections.size() > 0) {
            for (List<T> subList : collections.subList(0, 1)) {
                for (T element : subList) {
                    hs.add(element);
                }
            }
        }

        if (collections.size() > 1) {
            for (List<T> subList : collections.subList(1, collections.size())) {
                for (T element : subList) {
                    tempHS.add(element);
                }
                hs.retainAll(tempHS);
                tempHS.clear();
            }
        }
        
        return (List<T>)Arrays.asList(hs.toArray());
    }
}