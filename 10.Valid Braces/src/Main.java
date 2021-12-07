import java.util.*;

public class Main {
    /*
    TASK
    Write a function that takes a string of braces, and determines
    if the order of the braces is valid. It should return true if
    the string is valid, and false if it's invalid.

    All input strings will be nonempty, and will only consist of
    parentheses, brackets and curly braces: ()[]{}.
     */
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println(isValid(input));
    }

    //Optimal try2
    public static boolean isValid(String s) {
        int x = s.length();
        s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}","");
        return s.length() == x ? false : s.length() == 0 || isValid(s);
    }

    //Optimal try1
    private static boolean isValidBrackets(String input){
        String lastIteration = input;
        String currentIteration = input;
        do {
            lastIteration = currentIteration;
            currentIteration = lastIteration.replace("[]" , "").replace("{}", "").replace("()" , "");
        } while(currentIteration.length() < lastIteration.length());
        return currentIteration.equals("");
    }


    //My try
    /*private static boolean isValidBrackets(String input){
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c)) {
                // одна из открывающих скобок
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                // одна из закрывающих скобок
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        // в конце стек должен быть пустым
        return stack.isEmpty();
    }*/
}
