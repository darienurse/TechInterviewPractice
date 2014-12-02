import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Darien on 11/21/2014.
 */
public class FindValidParenthesis {
    public static void main(String[] args) {
        System.out.print(validParen(4));
        //printPar(4);
    }

    private static HashSet<String> validParen(int n) {
        HashSet<String> finalResults = new HashSet<String>();
        if (n == 1) {
            finalResults.add("()");
            return finalResults;
        }
        HashSet<String> results = validParen(n - 1);
        for (String s1 : results) {
            finalResults.add("()" + s1);
            finalResults.addAll(insertAfterLeftParen(s1));
        }
        return finalResults;
    }

    private static HashSet<String> insertAfterLeftParen(String s){
        HashSet<String> finalResults = new HashSet<String>();
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i)=='(')
                finalResults.add(s.substring(0,i+1)+ "()" + s.substring(i+1));
        }
        return finalResults;
    }

    public static void printPar(int l, int r, char[] str, int count) {
        if (l < 0 || r < l) return; // invalid state
        if (l == 0 && r == 0) {
            System.out.println(str); // found one, so print it
        } else {
            if (l > 0) { // try a left paren, if there are some available
                str[count] = '(';
                printPar(l - 1, r, str, count + 1);
            }
            if (r > l) { // try a right paren, if there’s a matching left
                str[count] = ')';
                printPar(l, r - 1, str, count + 1);
            }
        }
    }

    public static void printPar(int count) {
        char[] str = new char[count*2];
        printPar(count, count, str, 0);
    }
}
