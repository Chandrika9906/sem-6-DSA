import java.util.Scanner;

public class sum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while(n>9){
            int sum=0;
            {
                while(n>0){
            int res=n%10;
            sum=sum+res;
            n=n/10;
        }
        n=sum;
        }
    }
    System.out.println(n);
}
}

