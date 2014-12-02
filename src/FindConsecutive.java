import java.util.ArrayList;

/**
 * Created by Darien on 11/9/2014.
 */
public class FindConsecutive {

    public ArrayList<Integer> findConsecutiveRuns(int[] ints){
        int index1,index2,index3;
        if(ints.length < 3) //make sure array is long enough
            return null;
        //find valid indexes
        ArrayList<Integer> validIndexes = new ArrayList<Integer>();
        for(int i = 0; i + 2< ints.length; i++){
            index1 = ints[i];
            index2 = ints[i + 1];
            index3 = ints[i + 2];
            if((index1-index2 == 1 && index2 - index3 ==1) ||
                    (index1-index2 ==-1 && index2-index3==-1))
                validIndexes.add(i);
        }
        if(validIndexes.isEmpty())
            return null;
        else
            return validIndexes;
    }

    public static void main(String [] args)
    {
        //convert strings into ints
        final int[] ints = new int[args.length];
        for (int i=0; i < args.length; i++) {
            ints[i] = Integer.parseInt(args[i]);
        }
        FindConsecutive h = new FindConsecutive();
        System.out.println(h.findConsecutiveRuns(ints));
    }
}
