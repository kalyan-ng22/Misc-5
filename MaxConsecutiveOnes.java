// Time Complexity O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We perform a sliding window approach where we expand the sliding window until we encounter greater than k number of zeroes.
// At this point, we move the sliding window one step ahead and check if there is a zero at the start pointer. If yes, then our count get reduced
// and we expand the window towards right i.e end pointer so that we reach the longest path. We continue until we end pointer reaches the
// end of the nums array.

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;//start pointer
        int end = 0;//end pointer
        int count = 0;
        int result = 0;
        while (end < n) {//until end of array
            if (nums[end] == 0) {
                count++;
            }
            if (count > k) { //when k number of zeroes are exceeded
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
            result = Math.max(result, end - start + 1); //capture the max length
            end++;
        }
        return result;
    }
}