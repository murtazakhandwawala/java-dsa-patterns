class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //find out which is longer String
        // count the lenght of shorter String
        // in the length of shorter string window check those characters are present 
        // here we will use 26 char array for both of the strings
        // and we will compare the char array for that particular fixed window size and see if char count match - we can do this by using Arrays.equal(s1Array,s2Array) - it will match and return true if all characters match else false
        // increment r & l if we dont find a match - moving fixed window ahead

        int s1len = s1.length();
        int s2len = s2.length();

         if(s1len > s2len){
                return false;
            }

        
       
       int[] s1Arr = new int[26];
       int[] s2Arr = new int[26];

       for(int i =0;i<s1len;i++){

        s1Arr[s1.charAt(i) - 'a']++;
        s2Arr[s2.charAt(i) - 'a']++;
       }

       if(Arrays.equals(s1Arr,s2Arr)){
        return true;
       }


       int l =0;

       for(int r = s1.length();r<s2.length();r++){
        s2Arr[s2.charAt(l) - 'a']--;
        s2Arr[s2.charAt(r) - 'a']++;
        l++;
        if(Arrays.equals(s1Arr,s2Arr))
        {
            return true;
        }
       }
           return false;
            
      
    }
}
