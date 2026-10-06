class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        // we have position array, speed array and destination at target miles 
        // we have to consider the target as a position - as target will always be > positions
        // rearrange the array of position and speet in desc order so we can calculate the time the neaerst one will take to reach the destination
        // logic is to find the time taken by the nearest one and if its greater then the cars following it then it will create 1 fleet as all car will then move in same speed
    // example - position [4,1,0,7] .. speed [2,2,1,1]
    //sort in desc - position [7,4,1,0] .. [1,2,2,1]
    // des = 10 - lets create an array of time - [3,3,4.5,10]

     //lets combine two arrays into one for sorting purpose
    int totalCars = position.length;
     int[][] cars = new int[totalCars][2];

     for(int i = 0;i<totalCars;i++)
     {
        cars[i][0] = position[i];
        cars[i][1] = speed[i];
     }

     Arrays.sort(cars,(a,b)-> b[0]-a[0]);

     //find distance and store in stack 

        Stack<Double> fleet = new Stack<>();

     for(int i=0;i<totalCars;i++){


        if(fleet.isEmpty()){
            fleet.push((double)(target - cars[i][0])/cars[i][1]);
        }else{
            Double time = (double)(target - cars[i][0])/cars[i][1];

            if(fleet.peek()< time){
                fleet.push(time);
            }
        }
     }

return fleet.size();

    }
}
