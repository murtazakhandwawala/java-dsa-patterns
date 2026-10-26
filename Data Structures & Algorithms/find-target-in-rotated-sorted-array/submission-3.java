class Solution {
    public int search(int[] nums, int target) {
        
        //o(nlogn) is given by binary search 
        // as this is a rotated array = after finding m we need to check if left half is sorted or right half is sorted like num[l] < nums[m] - left is sorted and go there and see if the target falls in that boundary like - nums[l] < target && target <= nums[m]

        int l = 0;
        int r = nums.length-1;

        while(l<=r){
            int m = ((r-l)/2)+l;
            if(nums[m] == target){
                return m;
            }else if (nums[l] <= nums[m]){ //left half is soretd
                
                if(nums[l] <= target && target < nums[m]){
                    r = m-1;
                }else{
                    l = m+1;
                }

            }else{

                if(nums[r] >= target && target > nums[m]){
                    l = m+1;
                }else{
                    r = m-1;
                }
                
            }
        }

        return -1;
    }
}
