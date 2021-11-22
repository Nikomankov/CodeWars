import java.util.Scanner;
import org.apache.commons.lang3.text.WordUtils;

public class Main {
    /*
    Jaden Smith, the son of Will Smith, is the star of films such
    as The Karate Kid (2010) and After Earth (2013). Jaden is also
    known for some of his philosophy that he delivers via Twitter.
    When writing on Twitter, he is known for almost always capitalizing
    every word. For simplicity, you'll have to capitalize each word,
    check out how contractions are expected to be in the example below.

    Your task is to convert strings to how they would be written by
    Jaden Smith. The strings are actual quotes from Jaden Smith,
    but they are not capitalized in the same way he originally typed them.

    Example:

    Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
    Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
    Note that the Java version expects a return value of null for an empty
    string or null.
     */

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        //My try
        /*
        if(input == null || input.equals("")){
            System.out.println("null");
        }
        StringBuilder sb = new StringBuilder(input);
        int i = 0;
        int zeroCount = -1;
        while(zeroCount < 1){
            zeroCount = (i == 0 ? zeroCount+1 : zeroCount);
            sb.setCharAt(i, input.toUpperCase().charAt(i));
            i = input.indexOf(' ', i) + 1;
        }
        System.out.println(sb.toString());

         */

        //Optimal try
        if(input == ""){
            System.out.println("null");
        }
        else{
            System.out.println(WordUtils.capitalize(input));
        }
    }
}
