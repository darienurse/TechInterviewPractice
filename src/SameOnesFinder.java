import java.util.ArrayList;

/**
 * Created by Darien on 11/28/2014.
 */
public class SameOnesFinder {

    public int[] nextSmallAndLarge(int n){
        int x = n;
        int offset = 0;
        int largeAdjust = 0;
        int[] results = new int[2];
        boolean smallFound = false;
        boolean largeFound = false;
        IntToBinaryConverter converter = new IntToBinaryConverter();

        while(x > 0 && !(smallFound&&largeFound)){
            int y = x>>1;
            if(!smallFound && x%2==0 && y%2==1){ //TODO: Fix small method
                results[0] = n^(3<<offset);
                smallFound = true;
                largeAdjust = offset + 1;
            }
            else if(!largeFound && x%2==1 && y%2==0){
                int mask = ~(-1>>>(31-offset));
                int ones = -1>>>(32-(offset-largeAdjust));
                if(ones == -1) ones = 0;
                results[1] = (n^(3<<offset))&mask|ones;
                System.out.println(largeAdjust+" --- "+ offset);
                System.out.println(converter.printBinary(ones));
                largeFound = true;
            }
            x=y;
            offset++;
        }
        return results;
    }
}