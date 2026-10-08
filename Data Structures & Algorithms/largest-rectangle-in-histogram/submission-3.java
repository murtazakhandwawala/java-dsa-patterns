class Solution {
    public int largestRectangleArea(int[] heights) {
        // we need to check the min hight and keep going and calculating the total area - starting from 1 to 2 to 3
        // create a stack storing the index and bar hieght
        // while storing if we encounter a bar hieght smaller - which means we cant extand current bar so pop it out and record the max area
        // fill the stack - then at the end if stack has value calculate the area from it.

        int maxArea = 0;

        Stack<int[]> stack = new Stack<int[]>();

        for(int i = 0;i<heights.length;i++){
            int idx = i;
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                    idx = stack.peek()[1];
                    int area = stack.peek()[0] * (i-idx);
                    if(area > maxArea){
                        maxArea = area;
                    }
                    stack.pop();
                    //stack.push(new int[]{heights[i],idx});
                }
                stack.push(new int[]{heights[i],idx});
                
                
            }
        

        while(!stack.isEmpty()){
            int idx = stack.peek()[1];
                    int area = stack.peek()[0] * (heights.length-idx);
                    if(area > maxArea){
                        maxArea = area;
                    }
                    stack.pop();
        }

        return maxArea;
    }
}
