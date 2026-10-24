class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        //first condition - h should be greater then or equal to length of piles
        // we need to find min integer k - k will be smallest number in the pile
        // we need to subtract each pile with smalles number and find the total hours - those should be less then or equal to h - if not - take the second highest number and do same operation
        // so we can sort the array first and then use binary search to find the min value of k
        //if h equals the length of pile then we find the largest number in the pile
        // to use the binary search we need to create a array of min to max values available in pile and do a binary search and - for each value calculate how much time it will take and return the min.

        if(h<piles.length)
            return 0;
        Arrays.sort(piles);
        

        if(h == piles.length){
            return piles[piles.length-1];
        }else{
            
            int l = 1;
            int r = piles[piles.length-1];
            int k =0 ;

            while(l<=r){
                int m = ((r-l)/2) + l;

               if(findtime(m,piles,h)){
                    l = m+1;
                }
                else{
                    k = m;
                    r = m-1;
                }
            }

            return k;
        }
        
    }

    public boolean findtime(int k, int[] piles,int h){
            double t = 0;
        for(int i = 0;i<piles.length;i++)
        {
            t = Math.ceil((double)piles[i]/k) + t;
        }

        return t > h;
    }
}
