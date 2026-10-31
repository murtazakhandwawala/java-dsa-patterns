class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // we need to find the median without merging the two arrays
    // median = middle 2 elemnnt / 2
    //now if we sum the count of both array for example first one is 8 size and second oone is 7 = total 15 - we npw middle element should be index 8
    // formula to use here is - take the smaller array and find the middle element for it. example for us 4 would be middle index of 7. 15 - 4 = 11/2 = 5.5 - 5 is the element that wull form the middle element
    // check if the last element do first array of size 7 (last nmwans left geouonu lASG)

if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

   int num1l = nums1.length;
   int num2l = nums2.length;  

   int mid = (num1l + num2l +1) /2;

     int l = 0;
     int r = nums1.length;

        while(l<=r){
            int m = ((r-l)/2) +l;
            int n = mid-m;

            int maxLeftX = (m == 0) ? Integer.MIN_VALUE : nums1[m - 1];
            int minRightX = (m == num1l) ? Integer.MAX_VALUE : nums1[m];

            int maxLeftY = (n == 0) ? Integer.MIN_VALUE : nums2[n - 1];
            int minRightY = (n == num2l) ? Integer.MAX_VALUE : nums2[n];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((num1l + num2l) % 2 == 0){
                    int a = Math.max(maxLeftX, maxLeftY);
int b = Math.min(minRightX, minRightY);
               
               return (a+b)/2.0;}
               else{
                return Math.max(maxLeftX, maxLeftY);
               }
               
            }else if(maxLeftX > minRightY){
                
                r = m-1;
            }else{
                l = m+1;
            }
        }

   return 0;

    }
}
