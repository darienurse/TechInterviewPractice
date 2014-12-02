import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Darien on 11/22/2014.
 */
public class ChangeMaker {

    public static void main(String[] args) {
        System.out.print(makeChange(10));
        //printPar(4);
    }

    public static ArrayList<ArrayList<Integer>> makeChange(int c){
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(c<0) return results;
        if(c==0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        for (ArrayList<Integer> i : makeChange(c - 1)){
            i.add(1);
            if(getSum(i)==c)
                results.add(i);
        }
        for (ArrayList<Integer> i : makeChange(c-5)){
            i.add(5);
            if(getSum(i)==c)
                results.add(i);
        }
        for (ArrayList<Integer> i : makeChange(c-10)){
            i.add(10);
            if(getSum(i)==c)
                results.add(i);
        }
        for (ArrayList<Integer> i : makeChange(c-25)){
            i.add(25);
            if(getSum(i)==c)
                results.add(i);
        }
        return results;
    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for(int i : list)
            sum+=i;
        return sum;
    }
}
