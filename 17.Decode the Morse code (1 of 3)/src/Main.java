import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class Main {

    /*
    TASK

    The Morse code encodes every character as a sequence of
    "dots" and "dashes". For example, the letter A is coded as
    ·−, letter Q is coded as −−·−, and digit 1 is coded as
    ·−−−−. The Morse code is case-insensitive, traditionally
    capital letters are used. When the message is written in
    Morse code, a single space is used to separate the character
    codes and 3 spaces are used to separate words. For example,
    the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.

    NOTE: Extra spaces before or after the code have no meaning
    and should be ignored.

    In addition to letters, digits and some punctuation, there
    are some special service codes, the most notorious of those
    is the international distress signal SOS (that was first
    issued by Titanic), that is coded as ···−−−···. These special
    codes are treated as single special characters, and usually
    are transmitted as separate words.

    Your task is to implement a function that would take the morse
    code as input and return a decoded human-readable string.
     */

    public static void main(String[] args) {
        String input = " .... . -.--   .--- ..- -.. .";
        System.out.println(decode(input));
    }

    //My try
    public static String decode(String input){
        String output = "";
        String[] words = input.trim().split("   ");
        String[] chars;
        for(String word : words){
            chars = word.split(" ");
            for (String character : chars){
                String decoded = MorseCode.get(character);
                output += (decoded == "Not find!" ? "_" : decoded);
            }
            output += " ";
        }
        return output.trim();
    }

    //Java 8
    public static String decodeJava8(String morseCode) {
        return stream(morseCode.trim().split("   "))
                .map(Main::decodeWord)
                .collect(joining(" "));
    }
    private static String decodeWord(String word) {
        return stream(word.split(" ")).map(MorseCode::get).collect(joining());
    }

    //Another Java 8
    public static String decodeAnotherJava8(String morseCode) {
        return stream(morseCode.trim().split("   "))
                .map(word -> stream(word.split(" ")).map(MorseCode::get).collect(joining()))
                .collect(joining(" "));
    }
}
