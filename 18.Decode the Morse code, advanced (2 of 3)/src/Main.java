import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class Main {
    //TASK
    /*
    In this kata you have to write a Morse code decoder for
    wired electrical telegraph.
    Electric telegraph is operated on a 2-wire line with a
    key that, when pressed, connects the wires together, which
    can be detected on a remote station. The Morse code encodes
    every character being transmitted as a sequence of "dots"
    (short presses on the key) and "dashes" (long presses on the
    key).

    When transmitting the Morse code, the international standard
    specifies that:

    "Dot" – is 1 time unit long.
    "Dash" – is 3 time units long.
    Pause between dots and dashes in a character – is 1 time unit
    long.
    Pause between characters inside a word – is 3 time units long.
    Pause between words – is 7 time units long.
    However, the standard does not specify how long that "time unit"
    is. And in fact different operators would transmit at different
    speed. An amateur person may need a few seconds to transmit a
    single character, a skilled professional can transmit 60 words
    per minute, and robotic transmitters may go way faster.

    For this kata we assume the message receiving is performed
    automatically by the hardware that checks the line periodically,
    and if the line is connected (the key at the remote station is down),
    1 is recorded, and if the line is not connected (remote key is up),
    0 is recorded. After the message is fully received, it gets to you
    for decoding as a string containing only symbols 0 and 1.

    For example, the message HEY JUDE, that is ···· · −·−−   ·−−− ··− −·· ·
    may be received as follows:

    1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011

    As you may see, this transmission is perfectly accurate according
    to the standard, and the hardware sampled the line exactly two times
    per "dot".
     */

    public static void main(String[] args) {
        String bits = "000110011001100110000001100000011111100110011111100111111000000000000001100111111001111110011111100000011001100111111000000111111001100110000001100";
        String bitsTest = "01110";
        //System.out.println(decodeBits(bits));
        System.out.println(decodeMorse(decodeBits(bitsTest)));


    }

    //My try
    public static String decodeBits (String bits){
        //remove zeros
        int k = 0;
        while(bits.charAt(k) == '0'){
            k++;
        }
        bits = bits.substring(k);
        k = bits.length()-1;
        while (bits.charAt(k) == '0'){
            k--;
        }
        bits = bits.substring(0, k+1);
        System.out.println("bits in mid = " + bits);

        //find time unit
        char[] chars = bits.toCharArray();
        int timeUnit = 0;
        int midTimeUnit = 0;
        int maxTimeUnit = 0;
        char c = 'n';
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != c){
                timeUnit = timeUnit == 0 ? midTimeUnit : timeUnit;
                timeUnit = midTimeUnit < timeUnit & midTimeUnit != 0 ? midTimeUnit : timeUnit;
                maxTimeUnit = Math.max(midTimeUnit,maxTimeUnit);
                c = chars[i];
                midTimeUnit = 1;
            } else {
                midTimeUnit++;
            }
            System.out.println("c = " + c + ", poition = " + i);
            System.out.println("timeUnit = " + timeUnit + ", midTimeUnit = " +midTimeUnit + ", maxTimeUnit = " + maxTimeUnit);
        }
        timeUnit = timeUnit == 0 ? midTimeUnit : timeUnit;
        maxTimeUnit = Math.max(midTimeUnit,maxTimeUnit);

        System.out.println("timeUnit = " + timeUnit + ", midTimeUnit = " +midTimeUnit + ", maxTimeUnit = " + maxTimeUnit);
        if(timeUnit == maxTimeUnit){
            bits = bits.replaceAll(generateBits('1',timeUnit), ".")
                    .replaceAll(generateBits('0',timeUnit*7), "   ")
                    .replaceAll(generateBits('0',timeUnit*3), " ")
                    .replaceAll(generateBits('0',timeUnit), "");
        } else {
            bits = bits.replaceAll(generateBits('1', timeUnit*3), "-")
                    .replaceAll(generateBits('1',timeUnit), ".")
                    .replaceAll(generateBits('0',timeUnit*7), "   ")
                    .replaceAll(generateBits('0',timeUnit*3), " ")
                    .replaceAll(generateBits('0',timeUnit), "");
        }
        System.out.println("bits = " + bits);
        return bits;
    }

    public static String generateBits(char c, int count){
        String output = "";
        for(int i = 1; i <=count; i++){
            output += String.valueOf(c);
        }
        return output;
    }

    public static String decodeMorse(String morseCode) {
        return stream(morseCode.trim().split("\\s".repeat(3)))
                .map(word -> stream(word.split(" ")).map(MorseCode::get).collect(joining()))
                .collect(joining(" "));
    }

    //-------------------------------------------------------------------------

    //Optimal try
    public static String decodeBitsOptimal(String bits) {
        bits = bits.replaceAll("^0*|0*$", "");
        int timeUnit = Pattern.compile("0+|1+") //create a repeat pattern 0 or 1
                .matcher(bits)                  //find matches
                .results()
                .map(MatchResult::group)        //grouping
                .mapToInt(String::length)       //count lengths
                .min()                          //find minimal
                .orElseGet(bits::length);       //or take the length of the input string
        return bits.replace("111".repeat(timeUnit), "-")
                .replace("000".repeat(timeUnit), " ")
                .replace("1".repeat(timeUnit), ".")
                .replace("0".repeat(timeUnit), "");
    }

    public static String decodeMorseOptimal(String morseCode) {
        String decoded = "";
        for (String word : morseCode.split(" "))
            if (word.equals("")) decoded += " ";
            else decoded += MorseCode.get(word);
        return decoded;
    }
}
