import java.util.HashSet;
import java.util.Set;

/**
 * Created by Darien on 12/2/2014.
 */
public class NearByWordFinder {
         Set<String> nearbyWords(String input) {
            return getWords(input, 0);
         }

        private Set<String> getWords(String s, int index) {
            HashSet<String> results = new HashSet<String>();
            if(s.length()==index) {
                System.out.println(s);
                if (isword(s))
                    results.add(s);
            }
            else{
                String word;
                for(Character c : getNearbyChars(s.charAt(index))){
                    if(index ==0)
                        word = c + s.substring(1,s.length());
                    else
                        word = s.substring(0,index)+c+s.substring(index+1,s.length());
                    results.addAll(getWords(word, index+1));
                }
            }
            return results;
        }

        //Lame implementation of helpers.
        private Set<Character> getNearbyChars(Character character) {
            HashSet<Character> characters = new HashSet<Character>();
            if (character == 'g') {
                characters.add('g');
                characters.add('h');
                characters.add('f');
            } else {
                characters.add('i');
                characters.add('o');
                characters.add('k');
            }
            return characters;
        }

        boolean isword(String word) {
            return word.equals("go") || word.equals("hi");
        }
}
