import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k)dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1)result.add(nums[dq.peekFirst()]);

        }

        int[] ans = new int[result.size()];
        for(int i = 0 ;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;
        
        
    }
}