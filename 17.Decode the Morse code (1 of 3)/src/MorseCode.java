import java.util.HashMap;
import java.util.Map;

public class MorseCode {
    private static HashMap<String, String> morseLibrary = new HashMap<>() {{
        put(".-","A");
        put("-...","B");
        put("-.-.","C");
        put("-..","D");
        put(".","E");
        put("..-.","F");
        put("--.","G");
        put("....","H");
        put("..","I");
        put(".---","J");
        put("-.-","K");
        put(".-..","L");
        put("--","M");
        put("-.","N");
        put("---","O");
        put(".--.","P");
        put("--.-","Q");
        put(".-.","R");
        put("...","S");
        put("-","T");
        put("..-","U");
        put("...-","V");
        put(".--","W");
        put("-..-","X");
        put("-.--","Y");
        put("--..","Z");

        put(".----","1");
        put("..---","2");
        put("...--","3");
        put("....-","4");
        put(".....","5");
        put("-....","6");
        put("--...","7");
        put("---..","8");
        put("----.","9");
        put("-----","0");


        put("...---...","SOS");

    }};

    public static String get(String morseCode){
        for(String key : morseLibrary.keySet()){
            if(key.equals(morseCode)){
                return morseLibrary.get(key);
            }
        }
        return "Not find!";
    }
}
