public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2, 4, 5, 7, 8, 10}, n = 6, ele = 8;
        int i = 0, j = n-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid]==ele){
                System.out.println("Element found");
                return;
            }
            else if(arr[mid]<ele)
                i = mid + 1;
            else if(arr[mid]>ele)
                j = mid - 1;
        }

        System.out.println("Element not found");
    }
}

