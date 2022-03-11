import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    //TASK
    /*
    Complete the solution so that it strips all text that
    follows any of a set of comment markers passed in.
    Any whitespace at the end of the line should also be
    stripped out.
     */
    public static void main(String[] args) {

    }

    //My try
    public static String stripComments(String text, String[] commentSymbols) {
        String output = "";
        List<String> list = new ArrayList<>();
        text.lines().forEach(s -> list.add(s));
        for(String s : commentSymbols){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).isEmpty()) continue;
                int end = list.get(i).indexOf(s);
                if(end == -1) continue;
                list.set(i,list.get(i).substring(0,end));
            }
        }
        for(int i = 0; i < list.size(); i++){
            String line = list.get(i);
            boolean spaceAtEnd = line.endsWith(" ");
            while(spaceAtEnd){
                line = line.substring(0,line.length()-1);
                spaceAtEnd = line.endsWith(" ");
            }
            output += line + (i == list.size()-1 ? "" : "\n");
        }
        return output;
    }

    //Optimal try
    public static String stripCommentsOptimal(String text, String[] symbols) {
        return Arrays.stream(text.split("\n")).map(s -> {
            for (String symbol : symbols) s = s.replaceAll("(\\s+$)|(\\s*[" + symbol + "].*)", "");
            return s;
        }).collect(Collectors.joining("\n"));
    }
}
