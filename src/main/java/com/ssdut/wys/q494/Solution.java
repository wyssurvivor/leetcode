package com.ssdut.wys.q494;

/**
 * Created by Ryan on 17/3/25.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0) {
            if(S==0) {
                return 1;
            }else {
                return 0;
            }
        }
        int maxsum=0;
        for(int i=0;i<nums.length;i++) {
            maxsum+=nums[i];
        }
        if(S>maxsum||S<-maxsum) {
            return 0;
        }
        int [][] count = new int[nums.length][2*maxsum+1];
        int [][] _count = new int[nums.length][2*maxsum+1];
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<2*maxsum+1;j++) {
                count[i][j]=-1;
                _count[i][j]=-1;
            }
        }

        return find(nums,count,_count,nums.length-1,S);

    }

    public int find(int[] sums,int[][] count,int[][] _count,int index, int left) {
        int interCount = 0;
        if(index==0) {
            if(left==sums[index]) {
                interCount++;
            }

            if(left==-sums[index]) {
                interCount++;
            }
            if(left>=0) {
                count[0][left]=interCount;
            } else {
                _count[0][-left]=interCount;
            }

            return interCount;
        }

        if(left>=0&&count[index][left]!=-1) {
            return count[index][left];
        }

        if(left<0&&_count[index][-left]!=-1) {
            return _count[index][-left];
        }

        int count1=find(sums,count,_count,index-1,left+sums[index]);
        int count2=find(sums,count,_count,index-1,left-sums[index]);
        if(left>=0){
            count[index][left]=count1+count2;
        }else {
            _count[index][-left]=count1+count2;
        }

        return count1+count2;
    }

    public static void main(String[] args) {
        int[] sums=new int[]{1,1,1,1,1};
        int S=3;
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(sums, S));
    }
}
