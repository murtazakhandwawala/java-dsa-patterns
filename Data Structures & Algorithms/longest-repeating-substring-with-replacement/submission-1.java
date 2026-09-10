class Solution {
    public int characterReplacement(String s, int k) {
        
        //We will count the char occurance using HashMap
        //the see which is the least char and replace that with the most occuring char
        //traverse once again to replace
        // traverse to find the max count of substring
        // we have to use sliding window protocal here
        //set l and r in the beginning
        //add the char count in hashmap - 
       //instead of using hashmap - lets use a array of 26 chars which will store the count

       int[] allChar = new int[26]; 
        char[] chrarr = s.toCharArray();
        int maxCharCount = 0;
        int maxwin = 0;
        int l =0 ;
       
        s.length(); // you can take s lenght
        for(int r =0;r<chrarr.length;r++){ // we are terming this as r
            char chr = chrarr[r];
            allChar[chr - 'A']++; // at the position where our cur char is present increment its count

            maxCharCount = Math.max(maxCharCount,allChar[chr - 'A']);

            while(r-l+1 - maxCharCount > k){ // check the condition that the sliding window is valid or else move the left pointer - formular for sliding window r-l-1
            allChar[chrarr[l] - 'A'] --; //decrementing the char at l position as we are moving
            l++;
            }
            //we are finding a window which has windowsize - maxchar > k example - 5 - 4 > 1
            maxwin = Math.max(r-l+1, maxwin); // check valid window length

        }

       return maxwin;

    }
}
