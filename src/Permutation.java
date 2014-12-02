import java.util.ArrayList;

/**
 * Created by Darien on 11/21/2014.
 */
public class Permutation {

    public static void main(String[] args){
        System.out.print(permute("cate").size());
    }

    private static ArrayList<String> permute(String s) {
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<String> finalResults = new ArrayList<String>();
        if(s.length() == 1) {
            results.add(s);
            return results;
        }
        String remain = s.substring(1);
        char first = s.charAt(0);
        results = permute(remain);
        for(String s1: results){
            finalResults.addAll(insertAtEachIndex(s1,first));
        }
        return finalResults;
    }

    private static ArrayList<String> insertAtEachIndex(String s, char c){
        ArrayList<String> finalResults = new ArrayList<String>();
        for(int i = 0; i<= s.length(); i++){
            finalResults.add(s.substring(0,i)+ c + s.substring(i));
        }
        return finalResults;
    }
}
