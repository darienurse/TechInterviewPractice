/**
 * Created by Darien on 11/23/2014.
 */
public class Nqueens {
    public static void main(String[] args) {
        Nqueens nq = new Nqueens();
        nq.PlaceQueen(0);
    }


    int columnForRow[] = new int [8];
    boolean check(int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            if (diff == 0 || diff == row - i) return false;
        }
        return true;
    }
    void PlaceQueen(int row){
        if (row == 8) {
            System.out.println(columnForRow[0] + " " + columnForRow[7]);
            return;
        }
        for (int i = 0; i < 8; i++) {
            columnForRow[row]=i;
            if(check(row)){
                PlaceQueen(row+1);
            }
        }
    }
}
