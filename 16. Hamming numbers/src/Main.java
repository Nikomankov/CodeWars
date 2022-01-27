public class Main {
    public static void main(String[] args) {
     hamming(20);
    }

    public static long hamming(int n) {
        long[] numbers = new long[n];
        numbers[0] = 1;
        long x2 = 2, x3 = 3, x5 = 5;
        int i = 0, j = 0, k = 0;

        for (int index = 1; index < n; index++) {
            numbers[index] = Math.min(x2, Math.min(x3, x5));
            if (numbers[index] == x2) {
                x2 = 2 * numbers[++i];
            }
            if (numbers[index] == x3){
                x3 = 3 * numbers[++j];
            }
            if (numbers[index] == x5){
                x5 = 5 * numbers[++k];
            }
        }
        return numbers[n - 1];

    }
}
