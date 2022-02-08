import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class Main {

    //TASK
    /*
    In this kata you have to create all permutations of an input
    string and remove duplicates, if present. This means, you have
    to shuffle all letters from the input in all possible orders.
     */

    public static void main(String[] args) {
        String input = "aac";
        for (String s : singlePermutations(input)){
            System.out.println(s);
        }
    }
    //----------------------------------------------------------------

    //My try
    /*
    public static List<String> singlePermutations(String input) {
        List<String> output = new ArrayList<>();
        char[] inputArray = input.toCharArray();
        recursivePermutation(output, inputArray, inputArray.length);
        output = output.stream().distinct().collect(Collectors.toList());
        return output;
    }
    public static void recursivePermutation(List<String> output, char[] elements, int n) {
        if(n == 1) {
            output.add(toString(elements));
        } else {
            for(int i = 0; i < n-1; i++) {
                recursivePermutation(output, elements, n - 1);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            recursivePermutation(output, elements, n - 1);
        }
    }
    public static void swap(char[] input, int a, int b) {
        char c = input[a];
        input[a] = input[b];
        input[b] = c;
    }
    public static String toString(char[] input) {
        String newString = "";
        for(char c : input) {
            newString += c;
        }
        return newString;
    }*/
    //----------------------------------------------------------------

    //Java8 try
    /*
    public static List<String> singlePermutations(final String s) {
        return permute("", s);
    }

    private static List<String> permute(final String prefix, final String s) {

        return s.isEmpty()
                ? singletonList(prefix)
                : s.chars()
                .distinct()
                .mapToObj(i -> (char) i)
                .map(c -> permute(prefix + c, takeOut(s, c)))
                .flatMap(List::stream)
                .collect(toList());
    }

    static String takeOut(final String s, final char c) {
        final int i = s.indexOf(c);
        return s.substring(0, i) + s.substring(i + 1);
    }*/

    //Optimal try
    public static List<String> singlePermutations(String s) {
        Set<String> set = new HashSet<>();
        if (s.length() == 1) {
            set.add(s);
        } else {
            for (int i = 0; i < s.length(); i++) {
                List<String> temp = singlePermutations(s.substring(0, i) + s.substring(i + 1));
                for (String string : temp) {
                    set.add(s.charAt(i) + string);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
