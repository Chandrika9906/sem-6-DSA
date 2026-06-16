import java.util.*;
public class Main{
    static int calculate(int hrs){
        int res=0;
        if(hrs>8){
            res+=800+(hrs-8)*115;
        }
        else{
            res+=hrs*100;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sun=sc.nextInt();
        int mon=sc.nextInt();
        int tue=sc.nextInt();
        int wed=sc.nextInt();
        int thu=sc.nextInt();
        int fri=sc.nextInt();
        int sat=sc.nextInt();
        int res=0;
        res+=sun*150;
        res+=sat*125;
        res+=calculate(mon);
        res+=calculate(tue);
        res+=calculate(wed);
        res+=calculate(thu);
        res+=calculate(fri);
        System.out.println(res);
               
    }
}