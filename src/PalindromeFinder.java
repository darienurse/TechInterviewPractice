/**
 * Given a string S, you are allowed to convert it to a palindrome by adding 0 or more characters in front of it.
    Find the length of the shortest palindrome that you can create from S by applying the above transformation.
 */
public class PalindromeFinder {
    public String findPalindrome(String s){
        if(s.isEmpty()) return s;
        int mid = s.length()/2;
        String left, right;
        while(mid>0){
            left = getReverse(s.substring(0, mid));
            right = s.substring(mid+1,s.length());
            if(right.length()>=left.length() && left.equals(right.substring(0,left.length()))){ //If the result is an odd length palindrome
                String append = right.substring(left.length(), right.length());
                return getReverse(append)+ s;
            } else if(s.charAt(mid-1)==s.charAt(mid)){ //if the result is an even length palindrome
                left = getReverse(s.substring(0, mid-1));
                if(left.equals(right.substring(0,left.length()))) {
                    String append = right.substring(left.length(), right.length());
                    return getReverse(append)+ s;
                }
            }
            mid--;
        }
        return getReverse(s.substring(1,s.length()))+s;
    }

    public String getReverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}