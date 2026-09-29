class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length())
            return "";

        // we might use two loops to compare each character everytime but that will lead to o(n^2)
        // it will be a sliding window - we will move from start until we find our first match then using other pointer move to find other matches - until all found - store that substring. 
        // move the left to frist next later found and then repeat above process
        // create two 26 char arr - one for S and one for t. T will fixed. S will be changing as we move the pointer
        // we compare these arrays - if equal we find the size of substring if its smaller then the last one we save the substring - return smallest at the end.
        //until match is not found we will increase r by 1 everytime once match is found we will move l until no match found.

        int[] sArr = new int[128]; // its supports all ASCI characters - upper and lower case alphabets
        int[] tArr = new int[128];

        for(int i = 0;i<t.length();i++){
            tArr[t.charAt(i)]++; //creating array map for t
        }

        int need = 0; //how many char we need
        //count unique chars
        for(int count:tArr){
            if(count>0)
                need++;
        }

            int have =0;
            int l =0;
        int minLen = Integer.MAX_VALUE; //keep track of min length subsstring
        int minstart = 0; //

        for(int r =0;r<s.length();r++){//all the character with right pointer

            int rightChar = s.charAt(r);

            sArr[rightChar]++;

            if(tArr[rightChar] > 0 && tArr[rightChar] == sArr[rightChar]){ //if it contains then we have the required char
                have++;
            }

            while(have == need){ //shrink the window until valid

                if(r-l+1 < minLen){
                minstart = l;
                minLen = r-l+1;
                }

                int leftchar = s.charAt(l);
                sArr[leftchar]--;

                if(tArr[leftchar] >0 && tArr[leftchar] > sArr[leftchar]){//we are removing valid char and checking if still the char removed is present - incase of multiple
                    have--;
                }

                l++;
            }


        }
        return minLen == Integer.MAX_VALUE ? "" :s.substring(minstart,minstart+minLen);
    }
}
