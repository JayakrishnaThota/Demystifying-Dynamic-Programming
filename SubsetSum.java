/*
Given a set of non-negative integers and a sum, find if there is a subset which sums to the sum value
 */
public class SubsetSum {

    //O(2^n) time complexity and O(n) space complexity
    public boolean recursive(int[] nums, int target, int start){
        //Base cases
        if(target<0) return false;
        if(target==0) return true;
        if(start==nums.length) return false;
        return (recursive(nums, target-nums[start], start+1) || recursive(nums, target, start+1));
    }

    //O(n*sum) time and space complexity
    public boolean subsetSum(int[] nums, int sum){
        //Sanity check
        if(sum==0) return true;
        if(nums==null || nums.length==0) return false;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args){
        SubsetSum s = new SubsetSum();
        int[] set = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(s.recursive(set, sum, 0));
        System.out.println(s.subsetSum(set, sum));
    }
}
