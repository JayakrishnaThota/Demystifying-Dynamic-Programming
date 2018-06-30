/*
Given a non-negative number 'n', you need to print the nth fibonacci number
F0 = 0, F1 = 1
F(n) = F(n-1) + F(n-2)
*/
import java.util.*;
public class Fibonacci {

    //O(2^n) time and O(n) space complexity
    public int recursive(int n){
        //Base case
        if(n<0) return -1;//In ideal case, needs to throw an exception
        if(n==0) return 0;
        if(n==1) return 1;
        return recursive(n-1) + recursive(n-2);
    }

    //O(n) time and space complexity
    public int dpBottomUp(int n){
        if(n<0) return -1;//In ideal case, needs to throw an exception
        if(n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //O(n) time and space complexity
    public int dpTopDown(int n){
        if(n<0) return -1;//In ideal case, you need to throw an exception
        int[] topdown = new int[n+1];
        Arrays.fill(topdown, -1);
        topdown[0] = 0;
        topdown[1] = 1;
        return helper(n, topdown);
    }

    //O(n) time and space complexity
    public int helper(int n, int[] topdown){
        if(topdown[n]!=-1) return topdown[n];
        topdown[n] = helper(n-1, topdown) + helper(n-2, topdown);
        return topdown[n];
    }

    //O(n) time and O(1) space complexity
    public int spaceOptimized(int n){
        if(n<0) return -1;
        if(n<=1) return n;
        int a = 0, b = 1;
        int c = a+b;
        for(int i=2;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    //O(logn) time and 
    public
    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        System.out.println(f.recursive(9));
        System.out.println(f.dpBottomUp(9));
        System.out.println(f.dpTopDown(9));
        System.out.println(f.spaceOptimized(9));
        System.out.println(f.logarithmic(9));
    }
}
