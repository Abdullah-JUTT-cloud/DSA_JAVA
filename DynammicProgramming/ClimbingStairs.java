import java.util.Arrays;

public class ClimbingStairs {
    public static int climbStairsMemoization(int n,int[] climbStairs) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(climbStairs[n]!=-1){
            return climbStairs[n];
        }
        climbStairs[n] =climbStairsMemoization(n-1,climbStairs)+climbStairsMemoization(n-2,climbStairs);
        return climbStairs[n];
    }
    public static int climbStairsTabulation(int n){
        int countways[]=new int[n+1];
        countways[0]=1;
        for(int j=1;j<=n;j++){
            if(j==1){
                countways[j]=countways[j-1]+0;
            }else{
                countways[j]=countways[j-1]+countways[j-2];
            }
        }
        return countways[n];

    }
    public static void main(String[] args) {
        int n=5;
        int[] climbStairs=new int[n+1];
        Arrays.fill(climbStairs,-1);
        System.out.println(climbStairsMemoization(n,climbStairs));
        System.out.println(climbStairsTabulation(n));
    }
}
