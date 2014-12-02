import java.util.HashMap;

/**
 * Created by Darien on 11/30/2014.
 */
public class PatternFinder {
    public boolean findPattern(String pattern, String input, HashMap<Character, String> map, int index){
        if(input.isEmpty()) return false;
        StringBuilder result = new StringBuilder("");
        for(char c : pattern.toCharArray()){
            String piece = map.get(c);
            if(piece == null){
                for(int i = 1+index; i<=input.length(); i++){
                    HashMap <Character, String> copy = new HashMap <Character, String>(map);
                    copy.put(c, input.substring(index, i));
                    if(findPattern(pattern, input, copy, i)) return true;
                }
            }
            else
                result.append(piece);
        }
        System.out.println(result.toString()+"------"+input.equals(result.toString()));
        return input.equals(result.toString());
    }
}
