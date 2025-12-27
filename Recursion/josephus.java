import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class josephus {
    public static int count=0;
    public static int did(int n){
        if(n==0){
            return 0;
        }
        int lastd=n%10;
        if(n%2==0){
            count++;
        }
        did(n/10);
        return count;
    }
    public static void main(String[] args) {
        int n=2457689;
        System.out.println(did(n));
    }
}