import java.util.Arrays;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 5, 6, 8}, arr2[] = {2, 3, 7, 10, 11};
        int n1 = 4, n2 = 5;
        int res[] = new int[n1+n2];
        int i=0, j=0, k=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                res[k] = arr1[i];
                i++;
                k++;
            }
            else{
                res[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i<n1){
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j<n2){
            res[k] = arr2[j];
            j++;
            k++;
        }


        System.out.println(Arrays.toString(res));
    }
}
