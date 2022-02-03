import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    //TASK
    /*
    For a given chemical formula represented by a string, count
    the number of atoms of each element contained in the molecule
    and return an object Map<String,Integer>.

    For example:

    String water = "H2O";
    parseMolecule.getAtoms(water); // return [H: 2, O: 1]

    String magnesiumHydroxide = "Mg(OH)2";
    parseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]

    parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException
    As you can see, some formulas have brackets in them. The index outside
    the brackets tells you that you have to multiply count of each atom
    inside the bracket on this index. For example, in Fe(NO3)2 you have
    one iron atom, two nitrogen atoms and six oxygen atoms.

    Note that brackets may be round, square or curly and can also be
    nested. Index after the braces is optional.
     */
    public static void main(String[] args) {
        String input = "{((H)2)[O]}";
        getAtoms(input);

    }
    //My try
    public static Map<String,Integer> getAtoms(String formula) {
        //Exception
        String lastIteration;
        String currentIteration = formula.replaceAll("\\w+", "");
        do {
            lastIteration = currentIteration;
            currentIteration = lastIteration
                    .replace("[]" , "")
                    .replace("{}", "")
                    .replace("()" , "");
        } while(currentIteration.length() < lastIteration.length());
        if(!Pattern.compile("[A-Z]{1}[a-z]*").matcher(formula).find() || !currentIteration.equals("")){
            throw new IllegalArgumentException("wrong formula");
        }

        //Main logic
        HashMap<String, Integer> output = new HashMap<>();
        List<String> list = Pattern.compile("[A-Z]{1}[a-z]*")
                .matcher(formula)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
        for(int i = 0; i < list.size(); i++){
            //Cut off the left side
            formula = formula.substring(formula.indexOf(list.get(i))+list.get(i).length());
            //Removing closed brackets
            String clearFormula;
            String currentIteration1 = formula;
            do {
                clearFormula = currentIteration1;
                currentIteration1 = clearFormula
                        .replaceAll("[\\(\\{\\[]{1}[\\w]*[\\]\\}\\)]{1}[0-9]*", "");
            } while(currentIteration1.length() < clearFormula.length());
            //Change unnecessary molecules and closing brackets to spaces
            String[] array = clearFormula
                    .replaceAll("[\\)\\}\\]]+", " ")
                    .replaceAll("[A-Za-z]+[0-9]*", "")
                    .split("\\s");
            //Counting coefficient
            int count = 1;
            for(String s : array) count *= s.equals("") ? 1 :Integer.parseInt(s);
            System.out.println("I = " + list.get(i) + ", count = " + count);
            //Write on the map
            output.put(list.get(i), output.containsKey(list.get(i)) ? output.get(list.get(i)) + count : count);
        }

        output.forEach((k,v) -> System.out.println(k + " = " + v));
        return output;
    }
}
