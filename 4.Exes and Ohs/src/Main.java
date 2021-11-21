import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Check to see if a string has the same amount of 'x's and 'o's.
        The method must return a boolean and be case insensitive.
        The string can contain any char.

        Examples input/output:

        XO("ooxx") => true
        XO("xooxx") => false
        XO("ooxXm") => true
        XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
        XO("zzoo") => false
         */
        while(true){
            System.out.print("Please enter string: ");
            String input = new Scanner(System.in).nextLine();
            if(input.equals("0")){
                break;
            }

            //First try
            /*int xCount = 0;
            int oCount = 0;
            input = input.toLowerCase();
            boolean contO = input.contains("o");
            boolean contX = input.contains("x");
            boolean containOX = (contX & contO);
            if(containOX || !containOX){
                if((contO & !contX) || (!contO & contX)){
                    System.out.println(false);
                } else {
                    for(int i = 0; i < input.length(); i++){
                        xCount = (input.charAt(i) == 'x' ? ++xCount : xCount);
                        oCount = (input.charAt(i) == 'o' ? ++oCount : oCount);
                    }
                    System.out.println("o = " + oCount + "; x = " + xCount);
                    System.out.println((oCount == xCount ? true : false));
                }
            } else
                System.out.println(false);

             */

            //Optimal try
            System.out.println(input.replace("o","").length() == input.replace("x","").length());
        }


    }
}
