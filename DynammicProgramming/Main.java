
public class Main {
    public static int fibMemoization(int n,int[] fib) {
        if(n==0 || n==1){
            return n;
        }
        if(fib[n]!=0){
            return fib[n];
        }
        fib[n]=fibMemoization(n-1,fib)+fibMemoization(n-2,fib);
        return fib[n];
    }
    public static int fibTabulation(int n){
        int fib[]=new int [n+1];
        fib[0]=0;
        fib[1]=1;
        for(int i=2;i<=n;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
    public static void main(String[] args) {
         int n=6;
        int[] fib=new int[n+1];
        System.out.println( fibMemoization(n,fib));
        System.out.println( fibTabulation(n));
    }
}