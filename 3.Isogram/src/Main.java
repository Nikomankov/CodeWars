import java.util.Scanner;

public class Main {

    /*
    An isogram is a word that has no repeating letters, consecutive or non-consecutive.
    Implement a function that determines whether a string that contains only letters is
    an isogram. Assume the empty string is an isogram. Ignore letter case.

    "Dermatoglyphics" --> true
    "aba" --> false
    "moOse" --> false (ignore letter casing)
     */

    public static void main(String[] args) {
        while (true){
            System.out.print("Please enter a word: ");
            String input = new Scanner(System.in).nextLine();
            if(input.equals("0")){
                break;
            }

            //First try
            /*
            int repeatCount = 0;
            String inputLowCase = input.toLowerCase();
            for(int i = 0; i < input.length(); i++){
                for(int j = i + 1; j<(input.length()); j++){
                    repeatCount = (inputLowCase.charAt(i) == inputLowCase.charAt(j) ? ++repeatCount : repeatCount);
                }
            }
            System.out.println(input + " = " + (repeatCount > 0 ? false : true));
             */

            //Optimal try
            System.out.println(input + " = " + (input.length() == input.toLowerCase().chars().distinct().count()));


        }
    }
}
