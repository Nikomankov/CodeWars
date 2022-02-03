import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        String input = "K4[ON(SO3)2]2";
        getAtoms(input);
//        while(Pattern.compile("[\\[\\{\\(]+").matcher(input).find()){
//            input = input.replaceAll("[\\(\\{\\[]{1}[\\w]*[\\]\\}\\)]{1}[0-9]*", "");
//        }
//        input = input.replaceAll("[A-Za-z]*[0-9]*[\\)\\}\\]]+", " ");
        System.out.println(input);

    }
    public static Map<String,Integer> getAtoms(String formula) {
        HashMap<String, Integer> output = new HashMap<>();
        List<String> list = Pattern.compile("[A-Z]{1}[a-z]*")
                .matcher(formula)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
        if(list.isEmpty()){
            throw new IllegalArgumentException("wrong formula");
        }

        for(int i = 0; i < list.size(); i++){

            //Cut left part
            formula = formula.substring(formula.indexOf(list.get(i))+list.get(i).length());
            //Removing closed brackets
            String clearFormula = formula;
            while(Pattern.compile("[\\[\\{\\(]+").matcher(clearFormula).find()){
                clearFormula = clearFormula.replaceAll("[\\(\\{\\[]{1}[\\w]*[\\]\\}\\)]{1}[0-9]*", "");
            }
            //Change unnecessary molecules and closing brackets to spaces
            clearFormula = clearFormula.replaceAll("[A-Za-z]*[0-9]*[\\)\\}\\]]+", " ");


            int[] arrayInt = Arrays
                    .stream(clearFormula
                    .split("\\s"))
                    .mapToInt((String s) -> Integer.parseInt(s.trim()))
                    .toArray();
            String[] array = clearFormula.split("\\s");
            Integer count = 1;
            for(int s : arrayInt){
                count *= s;
            }
//            count *=Integer.parseInt(array[0]);
            System.out.println("I = " + list.get(i) + ", count = " + count);
            output.put(list.get(i), output.containsKey(list.get(i)) ? output.get(list.get(i)) + count : count);
        }

        output.forEach((k,v) -> System.out.println(k + " = " + v));
        return output;
    }
}
