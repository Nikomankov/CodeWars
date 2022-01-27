import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    /*
    TASK

    My friend John and I are members of the "Fat to Fit Club (FFC)".
    John is worried because each month a list with the weights of
    members is published and each month he is the last on the list
    which means he is the heaviest.

    I am the one who establishes the list so I told him: "Don't worry
    any more, I will modify the order of the list". It was decided to
    attribute a "weight" to numbers. The weight of a number will be
    from now on the sum of its digits.

    For example 99 will have "weight" 18, 100 will have "weight" 1 so
    in the list 100 will come before 99.

    Given a string with the weights of FFC members in normal order can
    you give this string ordered by "weights" of these numbers?
     */
    public static void main(String[] args) {
        String input = "103 123 4444 99 2000";
        System.out.println("output = " + orderWeight(input));
    }

    public static String orderWeight(String input) {
        String output = "";
        HashMap<Integer, String> map = new HashMap<>();
        String[] array = input.split("\\s");
        for(String weight : array){
            int key1 = Arrays.stream(Stream.of(weight.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray()).sum();
            map.put(key1, weight);
            map = Stream.of(map).sorted().;
            System.out.println("key = " + key1 + "; weight = " + weight);
        }
        Map<Integer, String> sortedMap = new TreeMap<>(map);
        int i = 0;
        for(String weight : sortedMap.values()){
            if(i < sortedMap.size() -1){
                output += weight + " ";
            } else output += weight;
            i++;
        }
        return output;
        // your code
    }
}
