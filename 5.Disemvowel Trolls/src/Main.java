import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /*
    Trolls are attacking your comment section!

    A common way to deal with this situation is to remove
    all of the vowels from the trolls' comments, neutralizing
    the threat.

    Your task is to write a function that takes a string and
    return a new string with all vowels removed.

    For example, the string "This website is for losers LOL!"
    would become "Ths wbst s fr lsrs LL!".

    Note: for this kata y isn't considered a vowel.
     */


    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        //My try
        /*
        Pattern pattern = Pattern.compile("[AEIOUaeiou]");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            System.out.println(matcher.replaceAll(""));
        }
        */

        //Optimal try
        System.out.println(input.replaceAll("[aAeEiIoOuU]", ""));
    }



}
