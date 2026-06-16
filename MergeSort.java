import java.util.Arrays;

public class MergeSort {
    static void merge(int arr[], int l, int mid, int r){
        int n1 = mid-l+1; //arr1 length
        int n2 = r-mid; //arr2 length
        int lArr[] = new int[n1], rArr[] = new int[n2];
        for(int i=0; i<n1; i++)
            lArr[i] = arr[l+i];

        for(int i=0; i<n2; i++)
            rArr[i] = arr[mid+i+1];

        int a = 0, b = 0, k = l;
        while(a<n1 && b<n2){
            if(lArr[a]<rArr[b]){
                arr[k] = lArr[a];
                a++;
                k++;
            }
            else{
                arr[k] = rArr[b];
                b++;
                k++;
            }
        }

        while (a<n1) {
            arr[k] = lArr[a];
            k++;
            a++;
        }

        while(b<n2){
            arr[k] = rArr[b];
            k++;
            b++;
        }
    }

    static void divide(int arr[], int i, int j){
        if(i<j){
            int mid = (i+j)/2;
            divide(arr, i, mid);
            divide(arr, mid+1, j);
            merge(arr, i, mid, j);
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 2, 6, 8}, n = 6;
        divide(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}