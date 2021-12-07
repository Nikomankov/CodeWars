import java.util.Scanner;

public class Main {
    /*
    Write a function that takes a string of parentheses,
    and determines if the order of the parentheses is valid.
    The function should return true if the string is valid,
    and false if it's invalid.
     */
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println(validParentheses(input));
    }

    public static boolean validParentheses(String parens)
    {
        if(!(parens.contains("(")|(parens.contains(")")))){
            return true;
        }
        parens = parens.replaceAll("[^()]", "");
        int x = parens.length();
        parens = parens.replaceAll("\\(\\)","");
        return parens.length() == x ? false : parens.length() == 0 || validParentheses(parens);
    }
}
