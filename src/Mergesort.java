/**
 * Created by Darien on 11/14/2014.
 */
public class Mergesort {

    static void sort(int[] input){
        mergeSort(input, 0, input.length-1);
    }
    static void mergeSort(int[] array, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while(left <= mid && right <= high){
            if(array[left] < array[right]) {
                temp[k] = array[left];
                left = left + 1;
            }
            else{
                temp[k] = array[right];
                right = right + 1;
            }
            k++;
        }
        if(left <= mid){
            while(left <= mid){
                temp[k] = array[left];
                left = left + 1;
                k = k + 1;
            }
        } else if(right <= high){
            while(right <= high){
                temp[k] = array[right];
                right = right +1;
                k = k + 1;
            }
        }
        for(int m=0 ; m < temp.length; m++)
            array[low+m] = temp[m];

    }

    static int[] readInputArray(){
        int[] a = {54,2,23,11,3,345,4};
        return a;
    }
    static void printArray(int[] array){
        for(int i = 0; i<array.length;i++){
            System.out.print(array[i]+" , ");
        }
    }

    public static void main(String[] args){
        int[] inputArray = readInputArray();
        System.out.println("INPUT ARRAY:" );
        printArray(inputArray);
        sort(inputArray);
        System.out.println("SORTED ARRAY: ");
        printArray(inputArray);
    }
}
