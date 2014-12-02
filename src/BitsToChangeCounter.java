/**
 * Created by Darien on 11/29/2014.
 */
public class BitsToChangeCounter {
    public int howMany(int a, int b){
        int count = 0;
        int num = a^b;
        while(num>0) {
            count += num % 2;
            num>>=1;
        }
        return count;
    }
}
