class Solution {
    public int lengthOfLongestSubstring(String s) {

        // we can split it into char Array
        // using sliding window
        // left pointer and right pointer 
        // move the right pointer until you find duplicate
        // find the size and check if its greater than the max
        // move left to next of duplicate char until the char is removed.


        char[] chr = s.toCharArray();
        int max = 0;
        HashSet<Character> chrset = new HashSet<>();
       
       int l = 0;
       int r = 0;

       while(r<chr.length && l <= r)
        {
            
               
                while(chrset.contains(chr[r])){
                    chrset.remove(chr[l]);
                    l++;}
                 
           
            
                chrset.add(chr[r]);
                r++;
                 max = Math.max(chrset.size(),max);

            
        }

        return max;
    }
}
