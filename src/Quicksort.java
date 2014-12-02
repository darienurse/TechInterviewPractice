public class Quicksort {

    private static <T extends Comparable<T>> void sort(T[] list, int lo, int hi) {
        //this is the recurise call to sort. We will only split if the array is great the length 1
        if(hi-lo <= 0 ){ //fewer than 2 items. Base condition met
            return;
        }
        int splitPoint = split(list, lo, hi); //split will return the index of our pivot after all the other
        // items have been sorted around the pivot. Split represents the 'heart of this algorithm
        sort(list, lo, splitPoint-1); // left subarray recursion
        sort(list, splitPoint+1, hi);//right subarray recursion
        
    }

    private static <T extends Comparable<T>> int split(T[] list, int lo, int hi) {
        //first setup left and right indexes
        //NOTE: lo represents the pivot which, at this point, is located the beginning of the array
        int left = lo+1;
        int right = hi;
        T pivot = list[lo];
        //Now we have to setup conditions for moving the left and right index pointers. We call these movements 'sweeps'
        while(true) {
            while (left <= right) {
                if (list[left].compareTo(pivot) < 0)
                    left++;
                else
                    break;
            }
            while (right > left) {
                if (list[right].compareTo(pivot) < 0)
                    break;
                else
                    right--;
            }
            if (left >= right) // if the left pointer has met or passed the right pointer, then we know we've finished
                break;
            //if left does not meet right, swap left and right items
            T temp = list[left];
            list[left] = list[right];
            list[right] = temp;
            //advance each pointer one step
            left++;
            right--;
        }

        //After all the sweeps are done, the pivot needs to be moved the split Point position
        //swap pivot with left-1 positiion
        list[lo] = list[left -1];
        list[left-1] = pivot;

        //return the split point
        return left-1;

    }

    public static <T extends Comparable<T>> void sort(T[] list){
        if(list.length <= 1)
            return;
        sort(list, 0, list.length-1);
    }


}
