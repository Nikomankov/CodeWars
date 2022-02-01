import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    //TASK
    /*
    Move the first letter of each word to the end of
    it, then add "ay" to the end of the word. Leave
    punctuation marks untouched.
     */

    public static void main(String[] args) {
        String input = "O tempora o mores !";
        System.out.println(pigIt(input));
    }

    //My try
    public static String pigIt(String str) {
        String output = str;
        Pattern pattern = Pattern.compile("[\\w-]+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            String newWord = str.substring(start,end);
            output = output.substring(0,start) +
                    output.substring(start).replaceFirst(newWord, newWord.substring(1) + newWord.charAt(0) + "ya");
        }
        return output;
    }

    //OptimalTry
    public static String pigIt1(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    //Java8 try
    public static String pigIt2(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }

}
