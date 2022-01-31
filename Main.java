import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    String arg1 = "(){}[]{}[]";
    String arg2 = "({[({[]})]})";
    String arg3 = "(([[}}}}";
    boolean function = isMatching(String.valueOf(arg2));
    System.out.println(arg2);
    System.out.println(function);
  }


  public static boolean isMatching(String characters){
    boolean match = false;
    if (characters.length()%2 == 0){
      match = isConsecutive(characters) || isNested(characters);
    }
    return match;
  }

  public static boolean isConsecutive(String characters){
    ArrayList<String> array = splitEqually(characters, 2);
    boolean yesItIs = false;
    for(int i = 0; i < array.size(); i++){
      if (allPossibleCombinations(array.get(i).substring(0,1), array.get(i).substring(1,2))){
        yesItIs = true;
      }
    }
    return yesItIs;
  }

  public static boolean isNested(String characters){
    ArrayList<String> list = new ArrayList<>(Arrays.asList(characters.split("")));
    ArrayList<String> obtainedPairs = new ArrayList<>();
    for(int i = 0; i < characters.length()/2; i++){
      obtainedPairs.add(list.get(i).concat(list.get(list.size()-i-1)));
    }
    String listString = String.join(", ", obtainedPairs);
    return isConsecutive(listString);
  }
  
  public static ArrayList<String> splitEqually(String text, int size) {
    ArrayList<String> ret = new ArrayList<String>((text.length() + size - 1) / size);

    for (int start = 0; start < text.length(); start += size) {
        ret.add(text.substring(start, Math.min(text.length(), start + size)));
    }
    return ret;
  }

  public static boolean allPossibleCombinations(String one, String two){
    boolean isCombination = false;
    if(one.equals("(") && two.equals(")")){
      isCombination = true;
    }
    if(one.equals("{") && two.equals("}")){
      isCombination = true;
    }
    if(one.equals("[") && two.equals("]")){
      isCombination = true;
    }
    return isCombination;
  }

}