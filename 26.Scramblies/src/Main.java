public class Main {
    //TASK
    /*
    Complete the function scramble(str1, str2) that returns true if a
    portion of str1 characters can be rearranged to match str2, otherwise
    returns false.

    Notes:
    Only lower case letters will be used (a-z). No punctuation or digits will be included.
    Performance needs to be considered.
     */

    public static void main(String[] args) {
        String str1 = "fallen";
        String str2 = "nal";
        System.out.println(scramble(str1,str2));
        System.out.println(scramble("rkqodlw","world")==true? "+" : "-");
        System.out.println(scramble("cedewaraaossoqqyt","codewars") == true? "+" : "-");
        System.out.println(scramble("katas","steak") == false ? "+" : "-");
        System.out.println(scramble("scriptjavx","javascript") == false ? "+" : "-");
        System.out.println(scramble("scriptingjava","javascript") == true ? "+" : "-");
        System.out.println(scramble("scriptingjava","javascript") == true ? "+" : "-");
        System.out.println(scramble("scriptsjava","javascripts") == true ? "+" : "-");
        System.out.println(scramble("javscripts","javascript") == false ? "+" : "-");
        System.out.println(scramble("aabbcamaomsccdd","commas") == true ? "+" : "-");
        System.out.println(scramble("commas","commas") == true ? "+" : "-");
        System.out.println(scramble("sammoc","commas") == true ? "+" : "-");

    }

    //my try
    public static boolean scramble(String str1, String str2){
        int counter = str2.length();
        for(char c : str2.toCharArray()){
            String charStr = Character.toString(c);
            if(str1.contains(charStr)){
                str1 = str1.replaceFirst(charStr,"");
                counter--;
            }
        }
        return counter == 0 ? true : false;
    }

    //Optimal try
    public static boolean scramble1(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        for (String s: str2.split("")) {
            if (!str1.contains(s))  return false;
            str1 = str1.replaceFirst(s,"");
        }
        return true;
    }
}

