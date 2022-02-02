import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    //TASK:
    /*
    Greed is a dice game played with five six-sided dice.
    Your mission, should you choose to accept it, is to score
    a throw according to these rules. You will always be given
    an array with five six-sided dice values.

    Three 1's => 1000 points
    Three 6's =>  600 points
    Three 5's =>  500 points
    Three 4's =>  400 points
    Three 3's =>  300 points
    Three 2's =>  200 points
    One   1   =>  100 points
    One   5   =>   50 point
    A single die can only be counted once in each roll. For example,
    a given "5" can only count as part of a triplet (contributing to
    the 500 points) or as a single 50 points, but not both in the same
    roll.

    Example scoring

    Throw       Score
    ---------   ------------------
    5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
    1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
    2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
    In some languages, it is possible to mutate the input to the function.
    This is something that you should never do. If you mutate the input,
    you will not be able to pass all the tests.
     */

    public static void main(String[] args) {
        int[] input = new int[]{5,1,3,4,1};
        System.out.println(greedy(input));
    }

    //My try
    public static int greedy(int[] dice){
        int score = 0;
        if(dice.length != 5) return 0;
        for(int i : Arrays.stream(dice).distinct().toArray()){
            int count = 0;
            for (int j : dice){
                count += i == j ? 1 : 0;
            }
            if(count >= 3 ){
                score += i == 1 ? i*1000 : i*100;
                count = count - 3;
            }
            score += i == 1 ? count * 100 : 0;
            score += i == 5 ? count * 10 * i : 0;
        }
        return score;
    }

    //Optimal try
    public static int greedy1(int[] dice) {
        int[] n = new int[7];
        for (int d : dice) n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }


}
