/**
 * Created by Darien on 11/28/2014.
 */
public class IntToBinaryConverter {
    public String printBinary(int n){
        String b = "";
        while(n>0){
            int r = n%2;
            n>>=1;
            b = r+b;
        }
        return b;
    }
}
