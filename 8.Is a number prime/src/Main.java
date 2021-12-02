import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println(isPrime(input));
        // проверяет, является ли int простым или нет.

    }
    //My try
//    static boolean isPrime(int input) {
//        if(input > 1){
//            if (input % 2 == 0 && !(input == 2)) return false;
//            for(int i = 3; i * i <= input; i += 2) {
//                if(input % i == 0)
//                    return false;
//            }
//            return true;
//        } else return false;
//    }

    //Optimal try
    static boolean isPrime(int input) {
        return input > 1 && BigInteger.valueOf(input).isProbablePrime(20);
    }
}
