import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;




public class Test {
    private static boolean compareList(List<Integer> l1, List<Integer> l2) {
        HashMap<Integer, Integer> l2Map = new HashMap<>();
        int size2 = l2.size();
        // value -> occurence in l2 MAP
        for (int i = 0; i < size2; ++i) {
            int occ = 1;
            if (l2Map.containsKey(l2.get(i))) occ = l2Map.get(l2.get(i)) + 1; 
            l2Map.put(l2.get(i), occ);
        }

        for (var ele : l1) {
            if (l2Map.containsKey(ele) && l2Map.get(ele) > 0) {//if found and there is still more to find (occ > 0)
                l2Map.put(ele, l2Map.get(ele)-1);//decrement the occ count
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    // identical lists
    List<Integer> l1 = List.of(1, 2, 3);
    List<Integer> l2 = List.of(1, 2, 3);
    System.out.println(compareList(l1, l2) == true);  // expected: true

    // same values, different order
    List<Integer> l3 = List.of(1, 2, 3);
    List<Integer> l4 = List.of(3, 2, 1);
    System.out.println(compareList(l3, l4) == true);  // expected: true

    // same values, different order again
    List<Integer> l5 = List.of(1, 2, 3);
    List<Integer> l6 = List.of(2, 3, 1);
    System.out.println(compareList(l5, l6) == true);  // expected: true

    // different values
    List<Integer> l7 = List.of(1, 2, 3);
    List<Integer> l8 = List.of(1, 2, 4);
    System.out.println(compareList(l7, l8) == false); // expected: false

    // all same values
    List<Integer> l9  = List.of(2, 2, 2);
    List<Integer> l10 = List.of(2, 2, 2);
    System.out.println(compareList(l9, l10) == true);  // expected: true

    // completely different
    List<Integer> l11 = List.of(1, 2, 3);
    List<Integer> l12 = List.of(4, 5, 6);
    System.out.println(compareList(l11, l12) == false); // expected: false

    // tricky — same values but one is duplicated differently
    List<Integer> l13 = List.of(1, 1, 3);
    List<Integer> l14 = List.of(1, 3, 3);
    System.out.println(compareList(l13, l14) == false); // expected: false
}
}