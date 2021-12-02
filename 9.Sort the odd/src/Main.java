import java.util.Arrays;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;

public class Main {
    /*
    You will be given an array of numbers. You have to sort
    the odd numbers in ascending order while leaving the
    even numbers at their original positions.

    Examples
    [7, 1]  =>  [1, 7]
    [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
    [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
     */
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 5};
    }

    //Optimal try
    static int[] sortArray(int[] array){
        OfInt sortedOdds = IntStream
                .of(array)
                .filter(i -> i % 2 == 1)
                .sorted()
                .iterator();

        return IntStream
                .of(array)
                .map(i -> i % 2 == 0 ? i : sortedOdds.nextInt())
                .toArray();
    }

    //My try
//    static int[] sortArray(int[] array){
//        //create an array of odd numbers
//        int[] oddArray = new int[(int) Arrays.stream(array).filter(x -> !(x%2==0)).count()];
//        int countOdd = 0;
//        for(int num : array){
//            if(!(num % 2 == 0)){
//                oddArray[countOdd] = num;
//                countOdd++;
//            }
//        }
//        //sort the odd array by selection
//        for (int i = 0; i < oddArray.length; i++) {
//            int min = oddArray[i];
//            int minId = i;
//            for (int j = i+1; j < oddArray.length; j++) {
//                if (oddArray[j] < min) {
//                    min = oddArray[j];
//                    minId = j;
//                }
//            }
//            int temp = oddArray[i];
//            oddArray[i] = min;
//            oddArray[minId] = temp;
//        }
//        //replace the odd numbers of the initial array with a sorted odd array
//        int countSortedOdd = 0;
//        for(int i = 0; i < array.length; i++){
//            if(!(array[i] % 2 == 0)){
//                array[i] = oddArray[countSortedOdd];
//                countSortedOdd++;
//            }
//        }
//        return array;
//    }
}
