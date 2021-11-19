import java.util.Locale;
import java.util.Scanner;

public class Main {

    /*Write a function that takes in a string of one or more words,
    and returns the same string, but with all five or more letter words
    reversed (Just like the name of this Kata). Strings passed in will
    consist of only letters and spaces. Spaces will be included only
    when more than one word is present.

    Examples: spinWords( "Hey fellow warriors" ) => returns
    "Hey wollef sroirraw" spinWords( "This is a test") => returns
    "This is a test" spinWords( "This is another test" )=> returns
    "This is rehtona test"*/

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        //String input = "Hello you there!";
        String[] arrString = input.split("[\\W]");
        for(String word : arrString){
            if(word.length() > 4){
                System.out.print(SpinWord(word) + " ");
            } else System.out.print(word  + " ");
        }
    }
    //Method for word spin
    public static String SpinWord (String in){
        String out = "";
        boolean upperCase = (Character.isUpperCase(in.charAt(0)) ? true : false );
        for(int i = in.length()-1; i >= 0 ; i--){
            if( upperCase & i == in.length()-1){
                in = in.toLowerCase();
                out += String.valueOf(in.charAt(i)).toUpperCase();
            } else
                out += in.charAt(i);
        }
        return out;
    }
}
