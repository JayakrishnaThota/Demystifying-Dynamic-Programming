public class ZeroOneKnapsack {

    //O(2^n) time and O(n) space complexity
    public int recursive(int[] v, int[] w, int c, int start){
        //Base Cases
        if(c==0) return 0;
        if(start==v.length) return 0;
        if(c-w[start]>=0){
            return Math.max(v[start] + recursive(v,w,c-w[start],start+1), recursive(v,w,c,start+1));
        }
        else{
            return recursive(v,w,c,start+1);
        }
    }

    //O(nC) time and O(nC) space complexity
    public int knapsack(int[] v, int[] w, int c, int start){
        int n = v.length;
        int[][] dp = new int[n+1][c+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=c;j++){
                if(j>=w[i-1]){
                    dp[i][j] = Math.max(v[i-1] + dp[i-1][j-w[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][c];
    }


    public static void main(String[] args){
        ZeroOneKnapsack z = new ZeroOneKnapsack();
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        System.out.println(z.recursive(val, wt, W, 0));
        System.out.println(z.knapsack(val, wt, W, 0));
    }
}
