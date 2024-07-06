class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> chk = new HashMap<Character, Integer>();
        char[] charArr = s.toCharArray();
        int maxValue = 0;
        int idx = 0;

        for(int i = 0; i < s.length(); i++){
            char c = charArr[i];
            if(chk.containsKey(c)){
                // cal max value
                idx = Math.max(idx, chk.get(c) + 1);
            }
            // setting c index
            chk.put(c, i);
            maxValue = Math.max(maxValue, i - idx + 1);
        }
        return maxValue;
    }
}