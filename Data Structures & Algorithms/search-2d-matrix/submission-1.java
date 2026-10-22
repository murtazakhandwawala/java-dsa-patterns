class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //2 by 2 matrix is sorted in descending order
        // we will use binary search here

        int s = 0;
        int er = matrix.length;
        int ec = matrix[0].length;
        int e = (er * ec) -1;
       

        //here we have to find the logic to find the the middle element. first we find the total length of 2d array for ex 3 by 4 = 12. do normal devision and addition of start. and then subtract that number with the length if row. and accordingly find the row and col
        while(s <= e){
            int[] mid = getRowColofmid(e,s,ec);
            int midV = matrix[mid[0]][mid[1]];
            if(midV == target){
                return true;
            }else if (midV > target){
                e = mid[2] - 1;   
            }else{
                s = mid[2] + 1;
            }
        }

        return false;

    }

    public int[] getRowColofmid(int e, int s,int ec){
        int m = ((e-s)/2)+s;

       int a = m/ec;
        int b = m%ec;

        return new int[]{a,b,m};
    }
}
