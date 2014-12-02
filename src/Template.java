import java.util.*;

/**
 * Created by Darien on 10/15/2014.
 */
public class Template {
    //primitives
    byte nextInStream;
    short hour;
    long totalNumberOfStars;
    float reactionTime;
    double itemPrice;

    //standard array. Same for primitives and classes
    int[] myIntArray1 = new int[3]; //new array of size 3
    int[] myIntArray2 = {1,2,3};
    int[] myIntArray3 = new int[]{1,2,3};
    String[] myStringArray1 = new String[3]; //new array of size 3
    String[] myStringArray2 = {"a","b","c"};
    String[] myStringArray3 = new String[]{"a","b","c"};

    //multi-dimensional
    int[][] num = new int[5][2];
    //arraylist
    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayList<String> arrayList2 = new ArrayList<String>(Arrays.asList("xyz", "abc")); //declared with default values

    public static void main(String [] args)
    {
        System.out.print(new NearByWordFinder().nearbyWords("gi"));
    }

    private void populateMultiArray(int[][] num, boolean efficient){
        if(efficient) {
            int[][] num2 = {{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        }
        else {
            num[0][0] = 1;
            num[0][1] = 2;
            num[1][0] = 1;
            num[1][1] = 2;
            num[2][0] = 1;
            num[2][1] = 2;
            num[3][0] = 1;
            num[3][1] = 2;
            num[4][0] = 1;
            num[4][1] = 2;
        }

    }
    private void accessArray(int[][] num, boolean efficient){
        if(efficient){
            for (int[] a : num) {
                for (int i : a) {
                    System.out.println(i);
                }
            }
        }
        else
            for (int i=0; i<(num.length); i++ ) {
                for (int j=0;j<num[i].length;j++)
                    System.out.println(num[i][j]);
            }
    }
}
