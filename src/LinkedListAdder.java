import java.util.LinkedList;

/**
 * Created by Darien on 12/1/2014.
 */
public class LinkedListAdder {
    public LinkedList<Integer> sum(LinkedList<Integer> a, LinkedList<Integer> b){
        LinkedList<Integer> c = new LinkedList<Integer>();
        int x, y, result;
        int carry = 0;
        while(!a.isEmpty() || !b.isEmpty() || carry != 0){
            x = (a.isEmpty()) ? 0:a.pop();
            y = (b.isEmpty()) ? 0:b.pop();
            result = x + y + carry;
            carry = result/10;
            c.add(result%10);
        }
        return c;
    }
}
