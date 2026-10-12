class Solution {
    public int search(int[] nums, int target) {
        
        //binary search is dividing the array in half and searching in upper or lower half. for this the list/array has to be sorted

        int s =0;
        int e = nums.length-1;

        while(s <= e){
            int m = ((e - s)/2)+s;
            if(nums[m] == target){
                return m;
            }
            else if(nums[m] < target){
                s = m+1;
                
            }else{
                e = m-1;
                
            }
        }

        return -1;
    }
}
