class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //brute force - 2 for loops - internal loop contantly checks the 3 element in the window and decide which one is max
        //two pointer apporach - we can start l =0 and r=k
        //first iteration we can check all in the window and find which one is greater and add in an result Array
        //after that we can check the if the number at l position is < then the largest then still we have largst and if the number at r is < then largest the large number remains same
        //if the l is the largest and r is not bigger or equal to larger or one less then larger then we will have to traverse the window to find the largest

        //here is max heap need to be implemented - which is priorityQueue in java

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]!=a[0]?b[0]-a[0]:b[1]-a[1]); // creating a maxheap with a comparator which can store value in desecnding order- if number are equal the largest index value is chosen

        int[] result = new int[nums.length-k+1]; //n-k+1

        for(int i =0;i<k;i++){ //adding the initial window in heap
            maxHeap.offer(new int[]{nums[i],i});
        }

        result[0] = maxHeap.peek()[0]; //getting max value from heap

        for(int i = k;i<nums.length;i++){

            maxHeap.offer(new int[]{nums[i],i}); //adding new incoming value in heap

            while(maxHeap.peek()[1] <= i-k){ //recorganzing heap for each iteration by ensuring the top value in heap is the one present in active window - else poll again
                maxHeap.poll();
            }

            result[i-k+1] = maxHeap.peek()[0]; //store the max value of that window
        }

        return result;
    }
}
