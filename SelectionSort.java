import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 8, 2, 3}, n = 6;
        for(int i=0; i<n; i++){
            int minInd = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minInd])
                    minInd = j;
            }
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}