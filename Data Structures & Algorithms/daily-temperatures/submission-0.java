class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //brute force is - 2 for loops - the second would be iterating to find which is the next day.add()
        // this is a stack ds poblem
        // we need to add the temp on stack and when we get to the next temp - check if its greater the pop first one - and find the index differnce and update the results
        // in stack store the index as well with the Temp. 

        int[] result = new int[temperatures.length];

        Stack<Integer> temp = new Stack<>();

        for(int i=0;i<temperatures.length;i++){

            

                while(!temp.isEmpty() && temperatures[i]>temperatures[temp.peek()]){
                    result[temp.peek()] = i - temp.peek();
                    temp.pop();
                }
                

             temp.push(i);
        }

        return result;
    }
}
