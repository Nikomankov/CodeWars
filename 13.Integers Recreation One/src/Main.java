import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    TASK

    Find all integers between m and n (m and n integers with
    1 <= m <= n) such that the sum of their squared divisors
    is itself a square.

    We will return an array of subarrays or of tuples (in C
    an array of Pair) or a string. The subarrays (or tuples
    or Pairs) will have two elements: first the number the
    squared divisors of which is a square and then the sum
    of the squared divisors.
     */

    public static void main(String[] args) {

        System.out.println(listSquaredMyTry(42, 250));
    }

    public static String listSquaredOptimalTry(long m, long n) {
        ArrayList<Long[]> list = new ArrayList<Long[]>();
        for(long x = m; x < n; x++){
            long sum = 0;
            for(long y = 1; y <= x; y++) if(x % y == 0) sum += (y * y);
            if (Math.sqrt(sum) % 1 == 0) list.add(new Long[]{x,sum});
        }
        return Arrays.deepToString(list.toArray());
    }

    public static String listSquaredMyTry(long m, long n) {
        String output = "";
        List<ArrayList<Long>> mainArray = new ArrayList<>();
        for(long i = m; i <= n; i++){
            long sumOfSquares = 0;
            ArrayList<Long> sqrtArray = new ArrayList<>();
            ArrayList<Long> dividers = new ArrayList<>();
            for(long j = 1; j <= i; j++){
                if (i % j == 0){
                    dividers.add(j);
                }
            }
            for(long divider : dividers){
                sumOfSquares += divider*divider;
            }
            double sumOfSquaresDouble = (double)sumOfSquares;
            if (Math.sqrt(sumOfSquaresDouble) % 1 == 0){
                sqrtArray.add(i);
                sqrtArray.add(sumOfSquares);
                mainArray.add(sqrtArray);
            }
        }
        output = mainArray.toString();
        return output;
    }
}
