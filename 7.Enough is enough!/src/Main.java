import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    /*
    Enough is enough!
    Alice and Bob were on a holiday. Both of them took
    many pictures of the places they've been, and now they
    want to show Charlie their entire collection. However,
    Charlie doesn't like these sessions, since the motive
    usually repeats. He isn't fond of seeing the Eiffel tower
    40 times. He tells them that he will only sit during the
    session if they show the same motive at most N times.
    Luckily, Alice and Bob are able to encode the motive as a
    number. Can you help them to remove numbers such that their
    list contains each number only up to N times, without
    changing the order?

    Task
    Given a list lst and a number N, create a new list that
    contains each number of lst at most N times without reordering.
    For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you
    take [1,2,3,1,2], drop the next [1,2] since this would lead
    to 1 and 2 being in the result 3 times, and then take 3,
    which leads to [1,2,3,1,2,3].
     */
    public static void main(String[] args) {
        //Console input
//        System.out.print("Please enter elements separated by commas: ");
//        String input = new Scanner(System.in).nextLine();
//        System.out.print("\n and max occurrences: ");
//        int maxOccurences = Integer.parseInt(new Scanner(System.in).nextLine());


        String inputString = "1, 2, 5, 6, 10, 10, 586, 1";
        String maxOccurencesString = "1";
        int maxOccurencesInt = Integer.parseInt(maxOccurencesString);

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);
        List<Integer> integerList = new ArrayList<Integer>();
        while (matcher.find()) {
            integerList.add(Integer.parseInt(matcher.group()));
        }
        System.out.println(integerList);

        for(int i = 0; i<integerList.size(); i++){
            int counterI = 0;
            for(int j = i+1; j<integerList.size(); j++){
                if(integerList.get(i).equals(integerList.get(j))){
                    counterI++;
                    if(counterI >= maxOccurencesInt){
                        integerList.remove(j);
                    }
                }
            }
        }
        System.out.println(integerList);
    }
}
