import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /*
    TASK

    To give credit where credit is due: This problem was
    taken from the ACMICPC-Northwest Regional Programming Contest.
    Thank you problem writers.

    You are helping an archaeologist decipher some runes. He knows
    that this ancient society used a Base 10 system, and that they
    never start a number with a leading zero. He's figured out most
    of the digits as well as a few operators, but he needs your help
    to figure out the rest.

    The professor will give you a simple math expression, of the form

    [number][op][number]=[number]
    He has converted all of the runes he knows into digits. The only
    operators he knows are addition (+),subtraction(-), and
    multiplication (*), so those are the only ones that will appear.
    Each number will be in the range from -1000000 to 1000000, and
    will consist of only the digits 0-9, possibly a leading -, and
    maybe a few ?s. If there are ?s in an expression, they represent
    a digit rune that the professor doesn't know (never an operator,
    and never a leading -). All of the ?s in an expression will
    represent the same digit (0-9), and it won't be one of the other
    given digits in the expression. No number will begin with a 0
    unless the number itself is 0, therefore 00 would not be a valid
    number.

    Given an expression, figure out the value of the rune represented
    by the question mark. If more than one digit works, give the lowest
    one. If no digit works, well, that's bad news for the professor -
    it means that he's got some of his runes wrong. output -1 in that
    case.

    Complete the method to solve the expression to find the value of
    the unknown rune. The method takes a string as a paramater
    repressenting the expression and will return an int value
    representing the unknown rune or -1 if no such rune exists.
     */

    public static void main(String[] args) {
        String[] input = new String[] {"1+1=?", "123*45?=5?088", "-5?*-1=5?", "19--45=5?", "--55*6?=66",
                "??*??=302?", "?*11=??", "??*1=??", "??+??=??"};
        for(String element : input){
            System.out.println(solveExpression(element));
        }

    }

    public static int solveExpression( final String expression ) {
        int missingDigit = -1;
        System.out.println("input " + expression);
        String regex = "\\-?[\\?\\d]+[\\+\\-\\*]{1}\\-?[\\?\\d]+\\={1}\\-?[\\?\\d]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        while(matcher.find()){
            System.out.println("nice: " + expression);
            int substringStartPos = 0;
            Pattern varPattern = Pattern.compile("\\-?[\\?\\d]+");
            String firstVar = "";
            String actionSign = "";
            String secondVar = "";
            String input = expression;
            for(int i = 0; i < 2; i++){
                input = input.substring(substringStartPos,input.length());
                Matcher varMatcher = varPattern.matcher(input);
                if(i == 0 && varMatcher.find()){
                    firstVar = input.substring(varMatcher.start(), varMatcher.end());
                    substringStartPos = varMatcher.end() + 1;
                    actionSign = input.substring(varMatcher.end(),varMatcher.end()+1);
                } if(i == 1 && varMatcher.find()) {
                    secondVar = input.substring(varMatcher.start(), varMatcher.end());
                    substringStartPos = varMatcher.end() + 1;
                }
            }
            String answer = input.substring(substringStartPos, input.length());
            /*System.out.println("firstVar = " + firstVar +
                    "\nsign = " + actionSign +
                    "\nsecondVar = " + secondVar +
                    "\nanswer = " + answer + "\n");*/
            int i = 0;
            boolean matchNum = false;
            while(!matchNum & i<10){
                switch (actionSign){
                    case("-"):
                        matchNum = ((decimalReplace(i, firstVar) - decimalReplace(i, secondVar)) == decimalReplace(i, answer) ? true : false);
                        missingDigit = (matchNum ? i : -1);
                        break;

                    case("+"):
                        matchNum = ((decimalReplace(i, firstVar) + decimalReplace(i, secondVar)) == decimalReplace(i, answer) ? true : false);
                        missingDigit = (matchNum ? i : -1);
                        break;

                    case("*"):
                        matchNum = ((decimalReplace(i, firstVar) * decimalReplace(i, secondVar)) == decimalReplace(i, answer) ? true : false);
                        missingDigit = (matchNum ? i : -1);
                        break;
                }
                i++;
            }
        }

        //Write code to determine the missing digit or unknown rune
        //Expression will always be in the form
        //(number)[opperator](number)=(number)
        //Unknown digit will not be the same as any other digits used in expression

        return missingDigit;
    }
    public static boolean checkNumber(int decimal){

    }
    public static int decimalReplace(int i, String decimal){
        int difference = decimal.length() - decimal.replaceAll("\\?","").length();
        return ((difference > 0) ? Integer.parseInt(decimal.replaceAll("\\?", Integer.toString(i))) : Integer.parseInt(decimal));
    }
}
