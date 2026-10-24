class Solution {
    public int findMin(int[] nums) {
        //the array sorted and rotated - 
        // we can use binary search and find the min number
        // based on the m found we will change are search 

        int l = 0;
        int r  = nums.length-1;
        int min = nums[0];

        while(l<=r){
            int m = ((r-l)/2)+l;
            if(min>nums[m])
            {   
                min = nums[m];
                r = m -1;
            }
            else{
                l = m+1;
            }


        }

        return min;
    }
}
