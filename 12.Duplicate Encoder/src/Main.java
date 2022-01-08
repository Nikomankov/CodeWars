import java.util.HashMap;
import java.util.Scanner;

public class Main {
    /*
    TASK

    The goal of this exercise is to convert a string to a new string where
    each character in the new string is "(" if that character appears only
    once in the original string, or ")" if that character appears more
    than once in the original string. Ignore capitalization when determining
    if a character is a duplicate.
     */

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println(EncoderMyTry(input));
    }

    public String EncoderOptimalTry(String input){
        input = input.toLowerCase();
        String result = "";
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            result += input.lastIndexOf(c) == input.indexOf(c) ? "(" : ")";
        }
        return result;
    }

    //My try
    public static String EncoderMyTry(String input) {
        String output = "";
        HashMap<Character, Integer> counter = new HashMap<>();
        for(char c : input.toCharArray()) {
            if (!counter.containsKey(c)) {
                counter.put(c, 1);
            } else {
                counter.put(c, counter.get(c) + 1);
            }
        }

        char[] inputCharArray = input.toCharArray();
        for(int i = 0; i < inputCharArray.length; i++) {
            if(counter.get(inputCharArray[i]) > 1){
                output += ")";
            } else {
                output += "(";
            }
        }
        return output;
    }
}
