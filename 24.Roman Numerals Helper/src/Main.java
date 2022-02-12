public class Main {
    //TASK
    /*
    Create a RomanNumerals class that can convert a roman numeral to and
    from an integer value. It should follow the API demonstrated in the
    examples below. Multiple roman numeral values will be tested for each
    helper method.

    Modern Roman numerals are written by expressing each digit separately
    starting with the left most digit and skipping any digit with a value
    of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC;
    resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII.
    1666 uses each Roman symbol in descending order: MDCLXVI.

    Input range : 1 <= n < 4000

    In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").

    Symbol	Value
    I	    1
    IV	    4
    V	    5
    X	    10
    L	    50
    C	    100
    D	    500
    M	    1000
     */

    public static void main(String[] args) {
        int input = 1999;
        String inputRoman  = "MMMXCV";
        System.out.println(toRoman(input));
        System.out.println(fromRoman(inputRoman));
    }

    //My try
    public static String toRoman(int n) {
        String output = "";
        int discarded = 0;
        for(int i = 1000; i >= 1; i = i/10){
            int consideredNum = (n - discarded)/i;
            output = switch (i){
                case 1000 -> "M".repeat(consideredNum);
                case 100 -> conversionToRoman(consideredNum,"M", "D", "C");
                case 10 -> conversionToRoman(consideredNum, "C", "L", "X");
                case 1 -> conversionToRoman(consideredNum, "X", "V", "I");
                default -> throw new IllegalStateException("Error");
            };
            discarded += consideredNum * i;
        }
        return output;
    }
    private static String conversionToRoman(int num, String tens, String five, String one){
        String output;
        int divResultBy5 = (num + 1) % 5 == 0 ? (num + 1)/5 : 0;
        output = switch (divResultBy5){
            case 1 -> one + five;
            case 2 -> one + tens;
            default -> five.repeat(num / 5) + one.repeat(num % 5);
        };
        return output;
    }

    public static int fromRoman(String romanNumeral) {
        int output = 0;
        String[] romanByTensArray  = {"MM","DC","LX","VI"};
        int tens = 1;
        int startDelPos;
        int endDelPos = romanNumeral.length();
        for(int i = 3; i >= 0 ; i--){
            int numberInt = 0;
            char ten = i != 0 ? romanByTensArray[i-1].charAt(1) : 'M';
            char five = romanByTensArray[i].charAt(0);
            char one = romanByTensArray[i].charAt(1);
            if(!romanNumeral.contains(Character.toString(one)) & !romanNumeral.contains(Character.toString(five))) {
                tens *= 10;
                continue;
            }
            //Separate numbers by tens
            int fivePos = romanNumeral.indexOf(five);
            int onePos = romanNumeral.indexOf(one);
            if(fivePos == -1) fivePos = onePos;
            if(onePos == -1) onePos = fivePos;
            startDelPos = Math.min(fivePos,onePos);
            System.out.println("one = " + one + ", five = " + five + ", ten = " + ten);
            System.out.println("onePos = " + onePos + ", fivePos = " + fivePos + ", startDelPos = " + startDelPos + ", endDelPos = " + endDelPos);
            String number = romanNumeral.substring(startDelPos,endDelPos);
            endDelPos = startDelPos;
            romanNumeral = romanNumeral.substring(0,startDelPos);
            //Convert to int by iterating
            if(i == 0 & number.contains("M")){
                numberInt = number.length();
            } else {
                for (char c : number.toCharArray()){
                    if(c == one){
                        numberInt++;
                    } else if(c == five){
                        numberInt = numberInt == 0 ? 5 : 5 - numberInt;
                    } else if(c == ten){
                        numberInt = numberInt != 0 ? 10 - numberInt : 10;
                    }
                }
            }
            output += tens*numberInt;
            System.out.println("romanNumeral = " + romanNumeral + ", number = " + number + ", numberInt = " + numberInt + ", tens = " + tens);
            System.out.println("output = " + output);
            System.out.println("----------------------------------------");
            tens *= 10;
        }
        return output;
    }
}
