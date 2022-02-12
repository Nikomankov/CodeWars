import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;

public class Main {
    //TASK
    /*
    In this kata you have to deal with "real-life" scenarios,
    when Morse code transmission speed slightly varies throughout
    the message as it is sent by a non-perfect human operator. Also
    the sampling frequency may not be a multiple of the length of a
    typical "dot".
    For example, the message HEY JUDE, that is ···· · −·−−   ·−−− ··− −·· ·
    may actually be received as follows:

    0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000

    As you may see, this transmission is generally accurate according
    to the standard, but some dots and dashes and pauses are a bit
    shorter or a bit longer than the others.

    Note also, that, in contrast to the previous kata, the estimated
    average rate (bits per dot) may not be a whole number – as the
    hypotetical transmitter is a human and doesn't know anything about
    the receiving side sampling rate.

    For example, you may sample line 10 times per second (100ms per
    sample), while the operator transmits so that his dots and short pauses
    are 110-170ms long. Clearly 10 samples per second is enough resolution
    for this speed (meaning, each dot and pause is reflected in the output,
    nothing is missed), and dots would be reflected as 1 or 11, but if you
    try to estimate rate (bits per dot), it would not be 1 or 2, it would
    be about (110 + 170) / 2 / 100 = 1.4. Your algorithm should deal with
    situations like this well.

    Also, remember that each separate message is supposed to be possibly
    sent by a different operator, so its rate and other characteristics
    would be different. So you have to analyze each message (i. e. test)
    independently, without relying on previous messages. On the other hand,
    we assume the transmission charactestics remain consistent throghout the
    message, so you have to analyze the message as a whole to make decoding
    right. Consistency means that if in the beginning of a message '11111' is
    a dot and '111111' is a dash, then the same is true everywhere in that
    message. Moreover, it also means '00000' is definitely a short (in-character)
    pause, and '000000' is a long (between-characters) pause.
     */
    public static void main(String[] args) {
        String input = "0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000";
        String test = "00000000000000011111111000000011111111111100000000000111111111000001111111110100000000111111111111011000011111111011111111111000000000000000000011111111110000110001111111111111000111000000000001111111111110000111111111100001100111111111110000000000111111111111011100001110000000000000000001111111111010111111110110000000000000001111111111100001111111111110000100001111111111111100000000000111111111000000011000000111000000000000000000000000000011110001111100000111100000000111111111100111111111100111111111111100000000011110011111011111110000000000000000000000111111111110000000011111000000011111000000001111111111110000000001111100011111111000000000111111111110000011000000000111110000000111000000000011111111111111000111001111111111001111110000000000000000000001111000111111111100001111111111111100100000000001111111100111111110111111110000000011101111111000111000000001001111111000000001111111111000000000111100001111111000000000000011111111100111111110111111111100000000000111111110000001100000000000000000000111111101010000010000001111111100000000011111000111111111000000111111111110011111111001111111110000000011000111111110000111011111111111100001111100001111111100000000000011110011101110001000111111110000000001111000011111110010110001111111111000000000000000000111111111110000000100000000000000000011110111110000001000011101110000000000011111111100000011111111111100111111111111000111111111000001111111100000000000001110111111111111000000110011111111111101110001111111111100000000111100000111100000111111111100000111111111111000000011111111000000000001000000111100000001000001111100111111111110000000000000000000010001111111100000011111111100000000000000100001111111111110111001111111111100000111111100001111111111000000000000000000000000011100000111111111111011110000000010000000011111111100011111111111100001110000111111111111100000000000000111110000011111001111111100000000000011100011100000000000011111000001111111111101000000001110000000000000000000000000000111110010000000000111111111000011111111110000000000111111111111101111111111100000000010000000000000011111111100100001100000000000000111100111100000000001100000001111111111110000000011111111111000000000111100000000000000000000111101111111111111000000000001111000011111000011110000000001100111111100111000000000100111000000000000111110000010000011111000000000000001111111111100000000110111111111100000000000000111111111111100000111000000000111111110001111000000111111110111111000000001111000000000010000111111111000011110001111111110111110000111111111111000000000000000000000000111111111110000000111011111111100011111110000000001111111110000011111111100111111110000000001111111111100111111111110000000000110000000000000000001000011111111110000000001111111110000000000000000000000011111111111111000000111111111000001111111110000000000111111110000010000000011111111000011111001111111100000001110000000011110000000001011111111000011111011111111110011011111111111000000000000000000100011111111111101111111100000000000000001100000000000000000011110010111110000000011111111100000000001111100011111111111101100000000111110000011110000111111111111000000001111111111100001110111111111110111000000000011111111101111100011111111110000000000000000000000000010000111111111100000000001111111110111110000000000000000000000110000011110000000000001111111111100110001111111100000011100000000000111110000000011111111110000011111000001111000110000000011100000000000000111100001111111111100000111000000001111111111000000111111111100110000000001111000001111111100011100001111111110000010011111111110000000000000000000111100000011111000001111000000000111111001110000000011111111000100000000000011111111000011001111111100000000000110111000000000000111111111111000100000000111111111110000001111111111011100000000000000000000000000";
        String decode = ".... . -.--   .--- ..- -.. .";
        System.out.println(decodeBitsAdvanced(test));
//        System.out.println(decodeMorse(decodeBitsAdvanced(test)));
    }

    public static String decodeMorse(String morseCode) {
        return stream(morseCode.trim().split("   "))
                .map(word -> stream(word.split(" ")).map(MorseCode::get).collect(joining()))
                .collect(joining(" "));
    }

    public static String decodeBitsAdvanced(String bits) {
        String output = "";
        bits = bits.replaceAll("^0*|0*$", "");
        int[] units = Pattern.compile("0+|1+") //create a repeat pattern 0 or 1
                .matcher(bits)                  //find matches
                .results()
                .map(MatchResult::group)        //grouping
                .mapToInt(String::length)       //count lengths
                .toArray();                     //find minimal
        for (int i : units){
            System.out.println("i = " + i);
        }
        System.out.println("");

        Map<Integer, Integer> unitsMap = stream(units)
                .mapToObj(u -> (int) u)
                .collect(Collectors.toList())
                .stream()
                .collect(HashMap::new,(m,c) ->{
            m.put(c, m.containsKey(c) ? (m.get(c) + 1) : 1);
        }, HashMap::putAll);
        unitsMap.forEach((k,v) -> System.out.println(k + " -> " + v));
        System.out.println("Units.length = " + units.length);


//        int max = Arrays.stream(units).max().getAsInt();
//        int min = Arrays.stream(units).min().getAsInt();
//        double minZone = 0, midZone = 0;

//        System.out.println("max = " + max + ", min = " + min);
//        if(max/min >= 6){
//            minZone = ((double)max/7.3)*2;
//            System.out.println(minZone);
//            midZone = minZone*2.4;
//        } else if(max/min >= 3){
//            minZone = ((double)max/3)*2;
//            System.out.println(minZone);
//            midZone = minZone*3;
//        } else {
//            minZone = min;
//            midZone = min*3;
//        }
//        System.out.println("minZone = " + minZone + ", midZone = " + midZone);
//
//        for(int i = 0; i < units.length; i++){
//            if(units[i] <= minZone){
//                output += i%2 == 0 ? "." : "";
//                System.out.println("minzone - " + (i%2 == 0 ? "1".repeat(units[i]) : "0".repeat(units[i])));
//            } if(units[i] <= midZone & units[i] > minZone){
//                output += i%2 == 0 ? "-" : " ";
//                System.out.println("midzone - " + (i%2 == 0 ? "1".repeat(units[i]) : "0".repeat(units[i])));
//            } if(units[i] > midZone){
//                output+= i%2 == 0 ? "o" : "   ";
//                System.out.println("maxzone - " + (i%2 == 0 ? "1".repeat(units[i]) : "0".repeat(units[i])));
//
//            }
//        }
        return output;
    }
}
